package com.example.appconectividadinternet.data.local

import com.example.appconectividadinternet.data.Pokemon
import com.example.appconectividadinternet.data.remote.FirstDataPokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepositoryLocalInterface {
    suspend fun requestAll():List<Pokemon>
    suspend fun add(pokemon:Pokemon)
    suspend fun getpokemonOneByOne(pokemon: FirstDataPokemon): Pokemon
    fun getStream(): Flow<List<Pokemon>>
}