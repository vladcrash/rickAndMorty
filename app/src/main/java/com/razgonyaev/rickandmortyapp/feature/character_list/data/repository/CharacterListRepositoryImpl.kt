package com.razgonyaev.rickandmortyapp.feature.character_list.data.repository

import com.razgonyaev.rickandmortyapp.feature.character_list.data.api.CharacterListApi
import com.razgonyaev.rickandmortyapp.feature.character_list.data.mapper.CharacterListResponseMapper
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.CharacterList
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.repository.CharacterListRepository
import io.reactivex.Single

class CharacterListRepositoryImpl(
    private val api: CharacterListApi,
    private val mapper: CharacterListResponseMapper,
) : CharacterListRepository {

    override fun getCharacterList(): Single<CharacterList> {
        return api.getCharacterList()
            .map(mapper::map)
    }
}