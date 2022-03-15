package com.razgonyaev.rickandmortyapp.db.di

import com.razgonyaev.rickandmortyapp.db.character_db.CharacterDao
import com.razgonyaev.rickandmortyapp.db.character_db.location.CharacterLocationDao

interface DatabaseApi {

    fun getCharacterDao(): CharacterDao

    fun getCharacterLocationDao(): CharacterLocationDao
}