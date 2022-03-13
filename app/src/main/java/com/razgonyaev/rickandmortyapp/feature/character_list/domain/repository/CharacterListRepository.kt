package com.razgonyaev.rickandmortyapp.feature.character_list.domain.repository

import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.CharacterList
import io.reactivex.Single

interface CharacterListRepository {
    fun getCharacterList(): Single<CharacterList>
}