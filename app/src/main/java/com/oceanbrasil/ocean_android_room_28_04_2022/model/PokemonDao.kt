package com.oceanbrasil.ocean_android_room_28_04_2022.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PokemonDao {
    @Query("SELECT * FROM PokemonEntity")
    fun findAll(): LiveData<List<PokemonEntity>>

    @Insert
    fun create(pokemon: PokemonEntity)

    @Update
    fun update(pokemon: PokemonEntity)

    @Delete
    fun delete(pokemon: PokemonEntity)

    @Query("DELETE FROM PokemonEntity")
    fun deleteAll()
}