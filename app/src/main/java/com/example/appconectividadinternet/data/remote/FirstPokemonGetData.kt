package com.example.appconectividadinternet.data.remote

data class FirstPokemonGetData(
    val count:String,
    val next: String?,
    val previous:String?,
    val results: List<FirstDataPokemon>

)

data class FirstDataPokemon(
    val name:String,
    val url:String
)
