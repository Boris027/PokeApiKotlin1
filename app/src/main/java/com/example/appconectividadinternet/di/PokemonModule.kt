package com.example.appconectividadinternet.di

import android.content.Context
import androidx.room.Room
import com.example.appconectividadinternet.data.local.PokemonLocalDao
import com.example.appconectividadinternet.data.local.PokemonLocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PokemonModule {

    @Provides
    fun providePokemonLocalDatabase(
        @ApplicationContext context: Context
    ): PokemonLocalDatabase {
        return Room.databaseBuilder(
            context,
            PokemonLocalDatabase::class.java,
            "pokemon_local_database"
        ).build()
    }

    @Provides
    fun providePokemonLocalDao(database: PokemonLocalDatabase): PokemonLocalDao {
        return database.PokemonDao()
    }
}