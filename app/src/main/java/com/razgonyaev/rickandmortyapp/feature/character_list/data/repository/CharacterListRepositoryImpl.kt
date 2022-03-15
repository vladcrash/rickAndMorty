package com.razgonyaev.rickandmortyapp.feature.character_list.data.repository

import com.razgonyaev.rickandmortyapp.db.character_db.CharacterDao
import com.razgonyaev.rickandmortyapp.feature.character_list.data.api.CharacterListApi
import com.razgonyaev.rickandmortyapp.feature.character_list.data.mapper.CharacterListDataMapper
import com.razgonyaev.rickandmortyapp.feature.character_list.data.mapper.CharacterListResponseMapper
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.CharacterList
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.repository.CharacterListRepository
import io.reactivex.Single

class CharacterListRepositoryImpl(
    private val api: CharacterListApi,
    private val apiMapper: CharacterListResponseMapper,
    private val characterDao: CharacterDao,
    private val dataMapper: CharacterListDataMapper,
) : CharacterListRepository {

    override fun getCharacterList(): Single<CharacterList> {
        return api.getCharacterList()
            .map(apiMapper::map)
            .flatMap { characterList ->
                characterDao
                    .insertCharacterList(characterList.let(dataMapper::mapToData))
                    .toSingleDefault(characterList)
            }.onErrorResumeNext(
                characterDao
                    .getCharacterList()
                    .map(dataMapper::mapFromData)
            )
    }
}