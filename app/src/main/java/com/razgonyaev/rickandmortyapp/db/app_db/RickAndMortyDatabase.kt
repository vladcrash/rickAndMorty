package com.razgonyaev.rickandmortyapp.db.app_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.razgonyaev.rickandmortyapp.db.character_db.CharacterDatabase
import com.razgonyaev.rickandmortyapp.db.character_db.CharacterEntity

private const val VERSION = 1

@Database(
    entities = [CharacterEntity::class],
    version = VERSION
)
abstract class RickAndMortyDatabase : RoomDatabase(), CharacterDatabase