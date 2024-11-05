package com.example.appconectividadinternet.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.example.appconectividadinternet.data.local.PokemonLocalRepository
import com.example.appconectividadinternet.data.remote.FirstDataPokemon
import com.example.appconectividadinternet.data.remote.PokemonRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class GeneralPokemonRepository @Inject constructor(
    private val pokemonRemoteRepository: PokemonRemoteRepository,
    private val pokemonLocalRepository: PokemonLocalRepository,
    private val context: Context
):PokemonRepository {
    private var _pokemon= mutableListOf<Pokemon>()
    private val _pokemonStream= MutableStateFlow<List<Pokemon>>(_pokemon.toList())

    override suspend fun requestAll(): List<Pokemon> {

        var pokemonsget:MutableList<Pokemon> = mutableListOf()
        try {
            pokemonsget.addAll(pokemonRemoteRepository.requestAll())
            for (a in pokemonsget){
                pokemonLocalRepository.add(a)

            }
        }catch (name:Exception){
            println("No hay conexion")
        }
        pokemonsget.addAll(pokemonLocalRepository.requestAll())
        _pokemon=pokemonsget;
        _pokemonStream.value=_pokemon.toList();

        return pokemonsget
    }

    override suspend fun getpokemonOneByOne(pokemon: FirstDataPokemon): Pokemon {
        TODO("Not yet implemented")
    }

    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }

    override fun getStream(): Flow<List<Pokemon>> {


        if(isOnline(context)){
            return pokemonRemoteRepository.getStream()
        }else{
            return pokemonLocalRepository.getStream()
        }


    }
}