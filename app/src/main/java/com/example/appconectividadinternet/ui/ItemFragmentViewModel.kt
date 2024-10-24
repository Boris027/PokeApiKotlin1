package com.example.appconectividadinternet.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appconectividadinternet.data.remote.PokemonRepository
import com.example.appconectividadinternet.data.remote.PokemonSingleGetData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemFragmentViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
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
                    _uiState.value=PokemonUiState.Success(pokemons)
                }
            }
        }
    }





}
sealed class PokemonUiState {
    data object Loading:PokemonUiState()
    class Success(val pokemons:List<PokemonSingleGetData>):PokemonUiState()
    class Error(val message:String):PokemonUiState()
}