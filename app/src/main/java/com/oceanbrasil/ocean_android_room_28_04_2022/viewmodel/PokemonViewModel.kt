package com.oceanbrasil.ocean_android_room_28_04_2022.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.oceanbrasil.ocean_android_room_28_04_2022.model.AppDatabase
import com.oceanbrasil.ocean_android_room_28_04_2022.model.PokemonDao
import com.oceanbrasil.ocean_android_room_28_04_2022.model.PokemonEntity

class PokemonViewModel(application: Application) : AndroidViewModel(application) {
    val pokemon: LiveData<List<PokemonEntity>>

    private val pokemonDao: PokemonDao

    init {
        val db = AppDatabase.getDatabase(application)

        pokemonDao = db.pokemonDao()

        pokemon = pokemonDao.findAll()
    }

    fun create(pokemon: PokemonEntity) {
        Thread {
            pokemonDao.create(pokemon)
        }.start()
    }
}