package com.razgonyaev.rickandmortyapp.db.di

import com.razgonyaev.rickandmortyapp.db.character_db.CharacterDao

interface DatabaseApi {

    fun getCharacterDao(): CharacterDao
}