package com.razgonyaev.rickandmortyapp.db.character_db

import com.razgonyaev.rickandmortyapp.db.character_db.location.CharacterLocationDao

interface CharacterDatabase {

    fun getCharacterDao(): CharacterDao

    fun getCharacterLocationDao(): CharacterLocationDao
}