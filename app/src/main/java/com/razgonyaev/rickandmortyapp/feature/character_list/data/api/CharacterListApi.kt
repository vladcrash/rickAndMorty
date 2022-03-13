package com.razgonyaev.rickandmortyapp.feature.character_list.data.api

import com.razgonyaev.rickandmortyapp.feature.character_list.data.model.CharacterListResponse
import io.reactivex.Single
import retrofit2.http.GET

private const val PATH = "character"

interface CharacterListApi {

    @GET(PATH)
    fun getCharacterList(): Single<CharacterListResponse>
}