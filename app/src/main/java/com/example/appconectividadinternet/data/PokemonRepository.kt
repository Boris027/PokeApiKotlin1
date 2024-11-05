package com.example.appconectividadinternet.data

import com.example.appconectividadinternet.data.remote.FirstDataPokemon
import com.example.appconectividadinternet.data.remote.PokemonSingleGetData
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun requestAll():List<Pokemon>
    suspend fun getpokemonOneByOne(pokemon: FirstDataPokemon): Pokemon
    fun getStream(): Flow<List<Pokemon>>
}