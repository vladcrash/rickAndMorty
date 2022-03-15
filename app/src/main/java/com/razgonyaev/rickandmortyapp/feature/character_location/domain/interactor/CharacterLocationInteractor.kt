package com.razgonyaev.rickandmortyapp.feature.character_location.domain.interactor

import com.razgonyaev.rickandmortyapp.feature.character_location.domain.model.CharacterLocation
import com.razgonyaev.rickandmortyapp.feature.character_location.domain.repository.CharacterLocationRepository
import io.reactivex.Single

class CharacterLocationInteractor(
    private val repository: CharacterLocationRepository
) {

    fun getLocation(characterId: Int): Single<CharacterLocation> {
        return repository.getLocation(characterId)
    }
}