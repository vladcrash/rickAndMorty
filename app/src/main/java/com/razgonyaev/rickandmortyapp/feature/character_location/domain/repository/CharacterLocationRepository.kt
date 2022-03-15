package com.razgonyaev.rickandmortyapp.feature.character_location.domain.repository

import com.razgonyaev.rickandmortyapp.feature.character_location.domain.model.CharacterLocation
import io.reactivex.Single

interface CharacterLocationRepository {
    fun getLocation(characterId: Int): Single<CharacterLocation>
}