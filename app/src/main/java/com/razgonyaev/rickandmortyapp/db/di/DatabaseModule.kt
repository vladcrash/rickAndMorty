package com.razgonyaev.rickandmortyapp.db.di

import android.content.Context
import com.razgonyaev.rickandmortyapp.db.app_db.RickAndMortyDatabase
import com.razgonyaev.rickandmortyapp.db.app_db.RickAndMortyDatabaseFactory
import com.razgonyaev.rickandmortyapp.db.character_db.CharacterDao
import com.razgonyaev.rickandmortyapp.db.character_db.CharacterDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DatabaseModule {

    @Singleton
    @Binds
    abstract fun provideCharacterDatabase(dataBase: RickAndMortyDatabase): CharacterDatabase

    companion object {

        @Singleton
        @Provides
        fun provideCharacterDao(characterDatabase: CharacterDatabase): CharacterDao {
            return characterDatabase.getCharacterDao()
        }

        @Singleton
        @Provides
        fun provideDatabase(context: Context): RickAndMortyDatabase {
            return RickAndMortyDatabaseFactory(context).create()
        }
    }
}