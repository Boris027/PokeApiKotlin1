package com.example.appconectividadinternet.data.local

import com.example.appconectividadinternet.data.Pokemon
import com.example.appconectividadinternet.data.PokemonRepository
import com.example.appconectividadinternet.data.remote.FirstDataPokemon
import com.example.appconectividadinternet.data.remote.PokemonSingleGetData
import com.example.appconectividadinternet.data.toLocalEntity
import com.example.appconectividadinternet.data.toPokemonLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonLocalRepository @Inject constructor(
    private val dao:PokemonLocalDao
):PokemonRepositoryLocalInterface {
    override suspend fun requestAll(): List<Pokemon> {
        return dao.getall().toPokemonLocal();
    }

    override suspend fun add(pokemon: Pokemon) {
        dao.insertar(pokemon.toLocalEntity())
    }

    override suspend fun getpokemonOneByOne(pokemon: FirstDataPokemon): Pokemon {
        TODO("Not yet implemented")
    }

    override fun getStream(): Flow<List<Pokemon>> {
        return dao.ObserveAll().map { list-> list.map { it.toPokemonLocal() } }
    }
}