package com.razgonyaev.rickandmortyapp.db.character_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
abstract class CharacterDao {

    @Query("SELECT * FROM `character/characters`")
    abstract fun getCharacterList(): Single<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCharacterList(list: List<CharacterEntity>): Completable
}