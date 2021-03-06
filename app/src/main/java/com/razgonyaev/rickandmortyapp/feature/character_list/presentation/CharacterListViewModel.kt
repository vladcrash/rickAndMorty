package com.razgonyaev.rickandmortyapp.feature.character_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.razgonyaev.rickandmortyapp.core.SingleLiveEvent
import com.razgonyaev.rickandmortyapp.core.base.BaseViewModel
import com.razgonyaev.rickandmortyapp.core.rx.RxSchedulers
import com.razgonyaev.rickandmortyapp.core.rx.addTo
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.interactor.CharacterListInteractor
import com.xwray.groupie.Section

class CharacterListViewModel(
    private val interactor: CharacterListInteractor,
    private val rxSchedulers: RxSchedulers,
    private val characterListFactory: CharacterListFactory,
) : BaseViewModel() {

    val characterListState: LiveData<CharacterListState>
        get() = _characterListState
    private val _characterListState = MutableLiveData<CharacterListState>(Uninitialized)

    val characterClickedId: LiveData<Int>
        get() = _characterClickedId
    private val _characterClickedId = SingleLiveEvent<Int>()

    fun onScreenVisible() {
        if (_characterListState.value == Uninitialized) {
            loadCharacterList()
        }
    }

    private fun loadCharacterList() {
        interactor.getCharacterList()
            .map { characterListFactory.createBody(it) { id -> _characterClickedId.value = id } }
            .subscribeOn(rxSchedulers.io())
            .observeOn(rxSchedulers.mainThread())
            .doOnSubscribe { _characterListState.value = Loading }
            .subscribe(::onSuccess, { onError() })
            .addTo(compositeDisposable)
    }

    private fun onSuccess(characterList: List<Section>) {
        _characterListState.value = Success(characterList)
    }

    private fun onError() {
        _characterListState.value = Error
    }
}