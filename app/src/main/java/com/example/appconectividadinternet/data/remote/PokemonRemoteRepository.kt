package com.example.appconectividadinternet.data.remote

import com.example.appconectividadinternet.data.Pokemon
import com.example.appconectividadinternet.data.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import com.example.appconectividadinternet.data.toPokemon


class PokemonRemoteRepository @Inject constructor(): PokemonRepositoryRemoteInterface {

    private var _pokemon= mutableListOf<Pokemon>()
    private val _pokemonStream=MutableStateFlow<List<Pokemon>>(_pokemon.toList())

    private val retrofitxd= Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val llamada: PokeTotalInterface =retrofitxd.create(PokeTotalInterface::class.java)
    private val llamadaindividual: PokeIndividualInterface =retrofitxd.create(
        PokeIndividualInterface::class.java)

    override suspend fun requestAll():List<Pokemon> {
        val data:FirstPokemonGetData=llamada.getUser().body()!!
        val pokemons: List<FirstDataPokemon> =data.results
        for (a in pokemons){
            _pokemon.add(getpokemonOneByOne(a))
        }


        _pokemonStream.value = _pokemon.toList()

        return _pokemon;
    }


    override suspend fun getpokemonOneByOne(pokemon:FirstDataPokemon):Pokemon{
        val a: PokemonSingleGetData? =llamadaindividual.getPoke(pokemon.name).body()

        return a!!.toPokemon()
    }

    override fun getStream(): Flow<List<Pokemon>> {
        return _pokemonStream
    }

}