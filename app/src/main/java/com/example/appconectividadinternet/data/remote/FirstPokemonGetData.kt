package com.example.appconectividadinternet.data.remote

data class FirstPokemonGetData(
    val count:Int,
    val next: Int?,
    val previous:Int?,
    val results: List<FirstDataPokemon>

)

data class FirstDataPokemon(
    val name:String,
    val url:String
)
