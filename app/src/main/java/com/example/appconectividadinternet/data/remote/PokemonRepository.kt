package com.example.appconectividadinternet.data.remote

import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun requestAll()
    suspend fun getpokemonOneByOne(pokemon:FirstDataPokemon):PokemonSingleGetData
    fun getStream(): Flow<List<PokemonSingleGetData>>
}