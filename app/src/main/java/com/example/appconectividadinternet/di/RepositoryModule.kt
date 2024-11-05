package com.example.appconectividadinternet.di

import com.example.appconectividadinternet.data.GeneralPokemonRepository
import com.example.appconectividadinternet.data.remote.PokemonRemoteRepository
import com.example.appconectividadinternet.data.PokemonRepository
import com.example.appconectividadinternet.data.local.PokemonLocalRepository
import com.example.appconectividadinternet.data.local.PokemonRepositoryLocalInterface
import com.example.appconectividadinternet.data.remote.PokemonRepositoryRemoteInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPokemonremoteRepository(pokemonRemoteRepository: PokemonRemoteRepository): PokemonRepositoryRemoteInterface

    @Binds
    @Singleton
    abstract fun bindPokemonlocalRepository(pokemonLocalRepository: PokemonLocalRepository): PokemonRepositoryLocalInterface


    @Binds
    @Singleton
    abstract fun bindPokemonRepository(GeneralPokemonRepository:GeneralPokemonRepository): PokemonRepository


}