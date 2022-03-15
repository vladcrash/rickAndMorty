package com.razgonyaev.rickandmortyapp.db.character_db

interface CharacterDatabase {

    fun getCharacterDao(): CharacterDao
}