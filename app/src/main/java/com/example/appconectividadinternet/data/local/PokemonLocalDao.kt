package com.example.appconectividadinternet.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.appconectividadinternet.data.Pokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonLocalDao {
    @Insert
    suspend fun insertar(vararg pokemonLocalEntity: PokemonLocalEntity)

    @Delete
    suspend fun delete(pokemonLocalEntity: PokemonLocalEntity)

    @Query("SELECT * FROM pokemon")
    suspend fun getall():List<PokemonLocalEntity>

    @Query("SELECT * FROM pokemon where id=:id")
    suspend fun getone(id:Int):List<PokemonLocalEntity>

    @Query("SELECT * FROM pokemon")
    fun ObserveAll(): Flow<List<PokemonLocalEntity>>


}