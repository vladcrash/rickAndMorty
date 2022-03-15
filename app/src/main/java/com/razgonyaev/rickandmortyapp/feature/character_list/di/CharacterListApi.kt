package com.razgonyaev.rickandmortyapp.feature.character_list.di

import androidx.lifecycle.ViewModelProvider
import com.razgonyaev.rickandmortyapp.feature.character_location.di.CharacterLocationViewModelQualifier

interface CharacterListApi {

    @CharacterListViewModelQualifier
    fun getCharacterListViewModelFactory(): ViewModelProvider.Factory

    @CharacterLocationViewModelQualifier
    fun getCharacterLocationViewModelFactory(): ViewModelProvider.Factory
}