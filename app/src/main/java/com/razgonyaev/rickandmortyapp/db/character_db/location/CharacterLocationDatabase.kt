package com.razgonyaev.rickandmortyapp.db.character_db.location

interface CharacterLocationDatabase {

    fun getCharacterLocationDao(): CharacterLocationDao
}