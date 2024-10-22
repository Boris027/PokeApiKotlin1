package com.example.appconectividadinternet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appconectividadinternet.data.PokeTotalInterface
import com.example.appconectividadinternet.databinding.FragmentItemListBinding
import retrofit2.Retrofit

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {


    private lateinit var binding: FragmentItemListBinding
    private var taskId:Int?=null
    private var columnCount = 1



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentItemListBinding.inflate(inflater,container,false)
        //val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        val adapter= MyItemRecyclerViewAdapter(listOf(1,2,3,4,5,6,7,8,9,10,11))
        binding.recyclerview.layoutManager=LinearLayoutManager(this.context)
        binding.recyclerview.adapter=adapter
        /*
        val retrofitxd=Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory()
            .build()
        val llamada:PokeTotalInterface=retrofitxd.create(PokeTotalInterface::class.java)
        */
        return binding.root
    }


}