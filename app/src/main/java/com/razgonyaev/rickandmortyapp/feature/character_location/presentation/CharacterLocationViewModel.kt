package com.razgonyaev.rickandmortyapp.feature.character_location.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.razgonyaev.rickandmortyapp.core.base.BaseViewModel
import com.razgonyaev.rickandmortyapp.core.rx.RxSchedulers
import com.razgonyaev.rickandmortyapp.core.rx.addTo
import com.razgonyaev.rickandmortyapp.feature.character_location.domain.interactor.CharacterLocationInteractor

class CharacterLocationViewModel(
    private val interactor: CharacterLocationInteractor,
    private val rxSchedulers: RxSchedulers,
    private val characterLocationFactory: CharacterLocationFactory,
) : BaseViewModel() {

    val characterLocationState: LiveData<CharacterLocationState>
        get() = _characterLocationState
    private val _characterLocationState = MutableLiveData<CharacterLocationState>(Uninitialized)

    fun onScreenVisible(characterId: Int) {
        if (_characterLocationState.value == Uninitialized) {
            loadCharacterList(characterId)
        }
    }

    private fun loadCharacterList(characterId: Int) {
        interactor.getLocation(characterId)
            .map(characterLocationFactory::create)
            .subscribeOn(rxSchedulers.io())
            .observeOn(rxSchedulers.mainThread())
            .doOnSubscribe { _characterLocationState.value = Loading }
            .subscribe(::onSuccess, { onError() })
            .addTo(compositeDisposable)
    }

    private fun onSuccess(characterLocationInfo: String) {
        _characterLocationState.value = Success(characterLocationInfo)
    }

    private fun onError() {
        _characterLocationState.value = Error
    }
}