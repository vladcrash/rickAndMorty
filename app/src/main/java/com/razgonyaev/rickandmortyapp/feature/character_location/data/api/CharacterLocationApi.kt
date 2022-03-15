package com.razgonyaev.rickandmortyapp.feature.character_location.data.api

import com.razgonyaev.rickandmortyapp.feature.character_location.data.model.CharacterLocationResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

private const val PATH = "location/{id}"

interface CharacterLocationApi {

    @GET(PATH)
    fun getLocation(@Path("id") characterId: Int): Single<CharacterLocationResponse>
}