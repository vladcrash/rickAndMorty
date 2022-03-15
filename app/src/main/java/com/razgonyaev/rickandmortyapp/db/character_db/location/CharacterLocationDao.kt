package com.razgonyaev.rickandmortyapp.db.character_db.location

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
abstract class CharacterLocationDao {

    @Query("SELECT * FROM `character/location` WHERE id = :characterId LIMIT 1")
    abstract fun getCharacterLocation(characterId: Int): Single<CharacterLocationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCharacterLocation(location: CharacterLocationEntity): Completable
}