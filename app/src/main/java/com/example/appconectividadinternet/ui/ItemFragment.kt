package com.example.appconectividadinternet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appconectividadinternet.data.PokeTotalInterface
import com.example.appconectividadinternet.data.remote.FirstDataPokemon
import com.example.appconectividadinternet.data.remote.FirstPokemonGetData
import com.example.appconectividadinternet.databinding.FragmentItemListBinding
import com.google.gson.JsonParser
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi


import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {


    private lateinit var binding: FragmentItemListBinding
    private var taskId:Int?=null
    private var columnCount = 1
    private val viewmodel:ItemFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentItemListBinding.inflate(inflater,container,false)
        val adapter= MyItemRecyclerViewAdapter(listOf(1,2,3,4,5,6,7,8,9,10,11))
        binding.recyclerview.layoutManager=LinearLayoutManager(this.context)
        binding.recyclerview.adapter=adapter



        val retrofitxd=Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val llamada:PokeTotalInterface=retrofitxd.create(PokeTotalInterface::class.java)

        viewmodel.viewModelScope.launch {
            println("hi")
            val data:FirstPokemonGetData=llamada.getUser().body()!!
            val pokemons: List<FirstDataPokemon> =data.results
            binding.textoprueba.text=pokemons[5].name
        }




        return binding.root
    }


}