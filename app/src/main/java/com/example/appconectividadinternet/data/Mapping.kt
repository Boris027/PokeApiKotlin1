package com.example.appconectividadinternet.data

import com.example.appconectividadinternet.data.local.PokemonLocalEntity
import com.example.appconectividadinternet.data.remote.FirstDataPokemon
import com.example.appconectividadinternet.data.remote.PokemonSingleGetData


/*fun List<FirstDataPokemon>.FromExternalToPokemon(): List<Pokemon> {
        return this.map{firstDataPokemon ->
            firstDataPokemon.toPokemonLocal()
        }
    }*/

    /*fun FirstDataPokemon.toPokemonLocal(): Pokemon {
        val imageurl=this.url
        return Pokemon(
                name = this.name,
                image = imageurl
        )
    }*/

    fun List<PokemonLocalEntity>.toPokemonLocal():List<Pokemon>{
        return this.map { firstData->
            firstData.toPokemonLocal()
        }
    }

    fun PokemonLocalEntity.toPokemonLocal():Pokemon{
        return Pokemon(
            id=this.id,
            name = this.name,
            image = this.image
        )
    }

    fun Pokemon.toLocalEntity():PokemonLocalEntity{
        return PokemonLocalEntity(
            id=this.id,
            name = this.name,
            image = this.image
        )
    }



    fun PokemonSingleGetData.toPokemon():Pokemon{
        return Pokemon(
            id = this.id,
            name = this.name,
            image = this.sprites.front_default
        )
    }


