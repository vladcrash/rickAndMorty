package com.razgonyaev.rickandmortyapp.db.app_db

import android.content.Context
import androidx.room.Room

private const val DATABASE_NAME = "rick_and_morty-room"

class RickAndMortyDatabaseFactory(
    private val context: Context,
) {

    fun create(): RickAndMortyDatabase {
        return Room
            .databaseBuilder(
                context,
                RickAndMortyDatabase::class.java,
                DATABASE_NAME
            )
            .build()
    }
}