package com.example.appconectividadinternet.data.remote

import com.example.appconectividadinternet.data.PokeIndividualInterface
import com.example.appconectividadinternet.data.PokeTotalInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class PokemonRemoteRepository @Inject constructor():PokemonRepository {

    private var _pokemon= mutableListOf<PokemonSingleGetData>()
    private val _pokemonStream=MutableStateFlow<List<PokemonSingleGetData>>(_pokemon.toList())

    private val retrofitxd= Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val llamada: PokeTotalInterface =retrofitxd.create(PokeTotalInterface::class.java)
    private val llamadaindividual: PokeIndividualInterface =retrofitxd.create(PokeIndividualInterface::class.java)

    override suspend fun requestAll(){
        val data:FirstPokemonGetData=llamada.getUser().body()!!
        val pokemons: List<FirstDataPokemon> =data.results
        for (a in pokemons){
            _pokemon.add(getpokemonOneByOne(a))
        }
        _pokemonStream.value = _pokemon.toList()
    }


    override suspend fun getpokemonOneByOne(pokemon:FirstDataPokemon):PokemonSingleGetData{
        return llamadaindividual.getPoke(pokemon.name).body()!!
    }

    override fun getStream(): Flow<List<PokemonSingleGetData>> {
        return _pokemonStream
    }

}