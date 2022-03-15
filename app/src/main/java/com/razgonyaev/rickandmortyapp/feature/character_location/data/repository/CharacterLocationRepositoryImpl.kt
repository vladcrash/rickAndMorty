package com.razgonyaev.rickandmortyapp.feature.character_location.data.repository

import com.razgonyaev.rickandmortyapp.feature.character_location.data.api.CharacterLocationApi
import com.razgonyaev.rickandmortyapp.feature.character_location.data.mapper.CharacterLocationResponseMapper
import com.razgonyaev.rickandmortyapp.feature.character_location.domain.model.CharacterLocation
import com.razgonyaev.rickandmortyapp.feature.character_location.domain.repository.CharacterLocationRepository
import io.reactivex.Single

class CharacterLocationRepositoryImpl(
    private val api: CharacterLocationApi,
    private val apiMapper: CharacterLocationResponseMapper,
) : CharacterLocationRepository {

    override fun getLocation(characterId: Int): Single<CharacterLocation> {
        return api.getLocation(characterId).map(apiMapper::map)
    }
}