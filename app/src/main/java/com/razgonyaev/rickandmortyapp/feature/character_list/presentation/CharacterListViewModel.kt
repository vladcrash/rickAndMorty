package com.razgonyaev.rickandmortyapp.feature.character_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.razgonyaev.rickandmortyapp.core.base.BaseViewModel
import com.razgonyaev.rickandmortyapp.core.rx.RxSchedulers
import com.razgonyaev.rickandmortyapp.core.rx.addTo
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.interactor.CharacterListInteractor
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section

class CharacterListViewModel(
    private val interactor: CharacterListInteractor,
    private val rxSchedulers: RxSchedulers,
    private val characterListFactory: CharacterListFactory,
    private val adapter: GroupieAdapter,
) : BaseViewModel() {

    val characterListState: LiveData<CharacterListState>
        get() = _characterListState
    private val _characterListState = MutableLiveData<CharacterListState>(Uninitialized)

    val adapterLiveData: LiveData<GroupieAdapter>
        get() = _adapterLiveData
    private val _adapterLiveData = MutableLiveData<GroupieAdapter>()

    fun onScreenVisible() {
        if (_characterListState.value == Uninitialized) {
            _adapterLiveData.value = adapter
            loadCharacterList()
        }
    }

    private fun loadCharacterList() {
        interactor.getCharacterList()
            .map(characterListFactory::createBody)
            .subscribeOn(rxSchedulers.io())
            .observeOn(rxSchedulers.mainThread())
            .doOnSubscribe { _characterListState.value = Loading }
            .subscribe(::onSuccess, { onError() })
            .addTo(compositeDisposable)
    }

    private fun onSuccess(characterList: List<Section>) {
        adapter.addAll(characterList)
        _characterListState.value = Success
    }

    private fun onError() {
        _characterListState.value = Error
    }
}