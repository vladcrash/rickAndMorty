package com.razgonyaev.rickandmortyapp.feature.character_location.data.mapper

import com.razgonyaev.rickandmortyapp.db.character_db.location.CharacterLocationEntity
import com.razgonyaev.rickandmortyapp.feature.character_location.domain.model.CharacterLocation

class CharacterLocationDataMapper {

    fun mapToData(characterLocation: CharacterLocation): CharacterLocationEntity =
        CharacterLocationEntity(
            id = characterLocation.id,
            name = characterLocation.name,
            residents = characterLocation.residents,
        )

    fun mapFromData(entity: CharacterLocationEntity): CharacterLocation =
        CharacterLocation(
            id = entity.id,
            name = entity.name,
            residents = entity.residents
        )
}