package com.example.appconectividadinternet.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import com.example.appconectividadinternet.data.PokeIndividualInterface
import com.example.appconectividadinternet.data.PokeTotalInterface
import com.example.appconectividadinternet.data.local.PokemonLocalDatabase
import com.example.appconectividadinternet.data.remote.FirstDataPokemon
import com.example.appconectividadinternet.data.remote.FirstPokemonGetData
import com.example.appconectividadinternet.data.remote.PokemonSingleGetData
import com.example.appconectividadinternet.databinding.FragmentItemListBinding
import com.google.gson.JsonParser
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel


import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class ItemFragment : Fragment() {


    private lateinit var binding: FragmentItemListBinding
    private var taskId:Int?=null
    private var columnCount = 1
    private val viewModel:ItemFragmentViewModel by viewModels()


    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemListBinding.inflate(inflater, container, false)



        binding.recyclerview.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState) {
                        is PokemonUiState.Error -> {
                            Toast.makeText(requireContext(), uiState.message, Toast.LENGTH_SHORT).show()
                        }

                        PokemonUiState.Loading -> {
                            Toast.makeText(requireContext(), "Cargando contenido", Toast.LENGTH_SHORT).show()
                        }

                        is PokemonUiState.Success -> {
                            val adapter = MyItemRecyclerViewAdapter(uiState.pokemons)
                            binding.recyclerview.adapter = adapter
                            Toast.makeText(requireContext(), "Cargado con éxito", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }



        return binding.root
    }


}