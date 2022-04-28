package com.oceanbrasil.ocean_android_room_28_04_2022.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.oceanbrasil.ocean_android_room_28_04_2022.R
import com.oceanbrasil.ocean_android_room_28_04_2022.model.PokemonEntity
import com.oceanbrasil.ocean_android_room_28_04_2022.viewmodel.PokemonViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        val tvPokemon = findViewById<TextView>(R.id.tvPokemon)

        pokemonViewModel.pokemon.observe(this) {
            tvPokemon.text = ""

            it.forEach { pokemon ->
                tvPokemon.append("${pokemon.name}\n")
            }
        }

        pokemonViewModel.create(PokemonEntity(null, "Charmander", "https://image"))
        pokemonViewModel.create(PokemonEntity(null, "Bulbasaur", "https://image"))
        pokemonViewModel.create(PokemonEntity(null, "Squirtle", "https://image"))
    }
}