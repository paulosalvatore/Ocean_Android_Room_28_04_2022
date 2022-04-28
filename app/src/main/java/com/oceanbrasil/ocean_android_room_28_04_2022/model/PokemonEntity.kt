package com.oceanbrasil.ocean_android_room_28_04_2022.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
    @PrimaryKey
    val id: Long?,

    val name: String,

    val imageUrl: String
)
