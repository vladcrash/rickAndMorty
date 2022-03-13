package com.razgonyaev.rickandmortyapp.feature.character_list.data.mapper

import com.razgonyaev.rickandmortyapp.feature.character_list.data.model.CharacterListResponse
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.Character
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.CharacterList
import com.razgonyaev.rickandmortyapp.feature.character_list.domain.model.Location

class CharacterListResponseMapper {

    fun map(from: CharacterListResponse): CharacterList =
        CharacterList(characterList = from.characterList.map { characterResponse ->
            Character(
                id = characterResponse.id,
                name = characterResponse.name,
                status = characterResponse.status,
                location = Location(
                    name = characterResponse.location.name,
                    url = characterResponse.location.url,
                ),
                imageUrl = characterResponse.imageUrl,
            )
        })
}