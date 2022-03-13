package com.razgonyaev.rickandmortyapp.feature.character_list.di

import androidx.lifecycle.ViewModelProvider

interface CharacterListApi {

    fun getCharacterListViewModelFactory(): ViewModelProvider.Factory
}