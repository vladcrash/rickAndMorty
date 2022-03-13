package com.razgonyaev.rickandmortyapp.feature.character_list.domain.interactor

import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.CharacterList
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.repository.CharacterListRepository
import io.reactivex.Single

class CharacterListInteractor(
    private val repository: CharacterListRepository,
) {

    fun getCharacterList(): Single<CharacterList> = repository.getCharacterList()
}