package com.example.appconectividadinternet.di

import android.content.Context
import androidx.room.Room
import com.example.appconectividadinternet.data.local.PokemonLocalDao
import com.example.appconectividadinternet.data.local.PokemonLocalDatabase
import com.example.appconectividadinternet.data.remote.PokemonRemoteRepository
import com.example.appconectividadinternet.data.remote.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPokemonRepository(pokemonRemoteRepository: PokemonRemoteRepository):PokemonRepository




}