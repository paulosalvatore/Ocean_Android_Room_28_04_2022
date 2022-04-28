package com.oceanbrasil.ocean_android_room_28_04_2022.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PokemonDao {
    @Query("SELECT * FROM PokemonEntity")
    fun findAll(): LiveData<List<PokemonEntity>>

    @Insert
    fun create(pokemon: PokemonEntity)
}