package com.razgonyaev.rickandmortyapp.feature.character_location.data.mapper

import com.razgonyaev.rickandmortyapp.feature.character_location.data.model.CharacterLocationResponse
import com.razgonyaev.rickandmortyapp.feature.character_location.domain.model.CharacterLocation

class CharacterLocationResponseMapper {

    fun map(response: CharacterLocationResponse): CharacterLocation =
        CharacterLocation(
            id = response.id,
            name = response.name,
            residents = response.residents,
        )
}