package com.razgonyaev.rickandmortyapp.feature.character_location.presentation

import com.razgonyaev.rickandmortyapp.feature.character_location.domain.model.CharacterLocation

class CharacterLocationFactory {

    fun create(location: CharacterLocation): String {
        return "There are ${location.residents} residents on ${location.name}"
    }
}