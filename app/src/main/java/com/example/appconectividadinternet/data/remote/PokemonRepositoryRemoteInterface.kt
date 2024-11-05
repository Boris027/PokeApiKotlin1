package com.example.appconectividadinternet.data.remote

import com.example.appconectividadinternet.data.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepositoryRemoteInterface {
    suspend fun requestAll():List<Pokemon>
    suspend fun getpokemonOneByOne(pokemon: FirstDataPokemon): Pokemon
    fun getStream(): Flow<List<Pokemon>>
}