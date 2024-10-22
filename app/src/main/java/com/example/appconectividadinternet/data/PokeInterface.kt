package com.example.appconectividadinternet.data

import com.example.appconectividadinternet.data.remote.FirstPokemonGetData
import com.example.appconectividadinternet.data.remote.PokemonSingleGetData
import com.squareup.moshi.Json
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeTotalInterface {
    @GET("pokemon?limit=10&offset=0")
    suspend fun getUser(): Response<FirstPokemonGetData>
}

interface PokeIndividualInterface{
    @GET("pokemon/{id}")
    suspend fun getPoke( @Path("id") id: String ):Response<PokemonSingleGetData>
}

