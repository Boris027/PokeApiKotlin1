package com.example.appconectividadinternet.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PokemonLocalEntity::class], version = 1)
abstract class PokemonLocalDatabase: RoomDatabase() {
    abstract fun PokemonDao(): PokemonLocalDao
}