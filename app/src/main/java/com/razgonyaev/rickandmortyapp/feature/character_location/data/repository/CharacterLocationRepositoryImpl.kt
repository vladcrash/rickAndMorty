package com.razgonyaev.rickandmortyapp.feature.character_location.data.repository

import com.razgonyaev.rickandmortyapp.db.character_db.location.CharacterLocationDao
import com.razgonyaev.rickandmortyapp.feature.character_location.data.api.CharacterLocationApi
import com.razgonyaev.rickandmortyapp.feature.character_location.data.mapper.CharacterLocationDataMapper
import com.razgonyaev.rickandmortyapp.feature.character_location.data.mapper.CharacterLocationResponseMapper
import com.razgonyaev.rickandmortyapp.feature.character_location.domain.model.CharacterLocation
import com.razgonyaev.rickandmortyapp.feature.character_location.domain.repository.CharacterLocationRepository
import io.reactivex.Single

class CharacterLocationRepositoryImpl(
    private val api: CharacterLocationApi,
    private val apiMapper: CharacterLocationResponseMapper,
    private val characterLocationDao: CharacterLocationDao,
    private val dataMapper: CharacterLocationDataMapper,
) : CharacterLocationRepository {

    override fun getLocation(characterId: Int): Single<CharacterLocation> {
        return api.getLocation(characterId)
            .map(apiMapper::map)
            .flatMap { characterList ->
                characterLocationDao
                    .insertCharacterLocation(characterList.let(dataMapper::mapToData))
                    .toSingleDefault(characterList)
            }.onErrorResumeNext(
                characterLocationDao
                    .getCharacterLocation(characterId)
                    .map(dataMapper::mapFromData)
            )
    }
}