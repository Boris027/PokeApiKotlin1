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
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.appconectividadinternet.databinding.FragmentItemListBinding
import dagger.hilt.android.AndroidEntryPoint


import kotlinx.coroutines.launch

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