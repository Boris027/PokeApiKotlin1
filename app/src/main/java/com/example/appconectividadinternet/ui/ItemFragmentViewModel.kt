package com.example.appconectividadinternet.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appconectividadinternet.data.Pokemon
import com.example.appconectividadinternet.data.local.PokemonLocalDao
import com.example.appconectividadinternet.data.PokemonRepository
import com.example.appconectividadinternet.data.remote.PokemonSingleGetData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemFragmentViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val pokemonLocalDao: PokemonLocalDao

):ViewModel() {

    private val _uiState = MutableStateFlow<PokemonUiState>(PokemonUiState.Loading)
    val uiState: StateFlow<PokemonUiState> get() = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            //carga todos los pokemons antes que nada
            pokemonRepository.requestAll()
            pokemonRepository.getStream().collect {
                pokemons -> if (pokemons.isEmpty()) {
                    _uiState.value=PokemonUiState.Error("No hay pokemons disponibles")
                }else{
                    //var hola:Pokemon=Pokemon(20000,"LOLO","www.com")
                    //pokemonLocalDao.insertar(hola)
                    pokemonLocalDao.getall()
                    println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                    println(pokemonLocalDao.getall())
                    _uiState.value=PokemonUiState.Success(pokemons)
                }
            }
        }
    }





}
sealed class PokemonUiState {
    data object Loading:PokemonUiState()
    class Success(val pokemons:List<Pokemon>):PokemonUiState()
    class Error(val message:String):PokemonUiState()
}