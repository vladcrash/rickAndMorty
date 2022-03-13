package com.razgonyaev.rickandmortyapp.feature.character_list.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterListResponse(
    @SerialName("results")
    val characterList: List<CharacterResponse>
)

@Serializable
data class CharacterResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("status")
    val status: String,
    @SerialName("location")
    val location: LocationResponse,
    @SerialName("image")
    val imageUrl: String,
)

@Serializable
data class LocationResponse(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)

