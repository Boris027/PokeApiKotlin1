package com.example.appconectividadinternet.di

import com.example.appconectividadinternet.data.remote.PokemonRemoteRepository
import com.example.appconectividadinternet.data.remote.PokemonRepository
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
    abstract fun bindPokemonRepository(pokemonRemoteRepository: PokemonRemoteRepository):PokemonRepository

}