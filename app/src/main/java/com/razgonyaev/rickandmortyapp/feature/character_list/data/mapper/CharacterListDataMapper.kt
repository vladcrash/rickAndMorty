package com.razgonyaev.rickandmortyapp.feature.character_list.data.mapper

import com.razgonyaev.rickandmortyapp.db.character_db.CharacterEntity
import com.razgonyaev.rickandmortyapp.db.character_db.LocationData
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.Character
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.CharacterList
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.Location

class CharacterListDataMapper {

    fun mapToData(characterList: CharacterList): List<CharacterEntity> =
        characterList.characterList.map { character ->
            CharacterEntity(
                id = character.id,
                name = character.name,
                status = character.status,
                location = LocationData(
                    name = character.location.name,
                    url = character.location.url,
                ),
                imageUrl = character.imageUrl,
            )
        }

    fun mapFromData(entityList: List<CharacterEntity>): CharacterList =
        CharacterList(
            characterList = entityList.map { entity ->
                Character(
                    id = entity.id,
                    name = entity.name,
                    status = entity.status,
                    location = Location(
                        name = entity.location.name,
                        url = entity.location.url,
                    ),
                    imageUrl = entity.imageUrl,
                )
            }
        )
}