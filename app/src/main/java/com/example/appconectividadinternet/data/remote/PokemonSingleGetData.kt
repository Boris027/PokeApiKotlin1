package com.example.appconectividadinternet.data.remote

data class PokemonSingleGetData(
    val id:Int,
    val name:String,
    val sprites:Sprites
)

data class Sprites(
    val front_default:String
)
