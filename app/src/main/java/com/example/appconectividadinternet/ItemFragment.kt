package com.example.appconectividadinternet

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appconectividadinternet.databinding.FragmentItemBinding
import com.example.appconectividadinternet.databinding.FragmentItemListBinding
import com.example.appconectividadinternet.placeholder.PlaceholderContent
import com.example.appconectividadinternet.placeholder.PlaceholderContent.PlaceholderItem

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


        return binding.root
    }


}