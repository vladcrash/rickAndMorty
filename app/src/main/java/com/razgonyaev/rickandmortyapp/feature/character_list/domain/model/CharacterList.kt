package com.razgonyaev.rickandmortyapp.feature.character_list.domain.model

data class CharacterList(
    val characterList: List<Character>,
)

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val location: Location,
    val imageUrl: String,
)

data class Location(
    val name: String,
    val url: String,
)

