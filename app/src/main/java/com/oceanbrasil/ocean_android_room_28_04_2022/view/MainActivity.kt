package com.oceanbrasil.ocean_android_room_28_04_2022.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        // Visualizar pokémon adicionados
        val tvPokemon = findViewById<TextView>(R.id.tvPokemon)

        pokemonViewModel.pokemon.observe(this) {
            tvPokemon.text = ""

            it.forEach { pokemon ->
                tvPokemon.append("${pokemon.name}\n")
            }
        }

        // Criar alguns pokémon
        pokemonViewModel.create(PokemonEntity(null, "Charmander", "https://image"))
        pokemonViewModel.create(PokemonEntity(null, "Bulbasaur", "https://image"))
        pokemonViewModel.create(PokemonEntity(null, "Squirtle", "https://image"))

        // Criação de pokémon
        val etPokemon = findViewById<EditText>(R.id.etPokemon)
        val btAdicionar = findViewById<Button>(R.id.btAdicionar)

        btAdicionar.setOnClickListener {
            val nomePokemon = etPokemon.text.toString()
            val novoPokemon = PokemonEntity(null, nomePokemon, "https://image")
            pokemonViewModel.create(novoPokemon)

            // Limpar o EditText após adicionar
            etPokemon.setText("")
        }

        // Botão para limpar DB
        val btLimparDB = findViewById<Button>(R.id.btLimparDB)

        btLimparDB.setOnClickListener {
            pokemonViewModel.deleteAll()
        }
    }
}