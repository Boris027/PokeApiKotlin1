package com.example.appconectividadinternet.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "pokemon")
data class PokemonLocalEntity(

    @PrimaryKey val id: Int,
    val name:String,
    val image:String
)
