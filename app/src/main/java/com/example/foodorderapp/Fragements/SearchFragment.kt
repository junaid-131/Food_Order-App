package com.example.foodorderapp.Fragements

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.Adapters.menuAdapter
import com.example.foodorderapp.R

import com.example.foodorderapp.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var adapter: menuAdapter
    private val originalmenuFoodname = listOf("burger","pizza","fries","burger","pizza","fries")
    private val originalMeneuItemPrice = listOf("$6","$9","$3","$6","$9","$3")
    private val originalMenuImage = listOf(R.drawable.burger, R.drawable.pizza,R.drawable.fries,R.drawable.burger,R.drawable.pizza,R.drawable.fries)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    private val filtermenufoodname = mutableListOf<String>()
    private val filtermenufoodprice = mutableListOf<String>()
    private val filtermenuimage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = menuAdapter(filtermenufoodname,filtermenufoodprice,filtermenuimage,requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter =adapter


        //Search View
        setupSearchView()
        //show all menu item
        showallmenu()

        return binding.root
    }

    private fun showallmenu() {
        filtermenufoodname.clear()
        filtermenufoodprice.clear()
        filtermenuimage.clear()

        filtermenufoodname.addAll(originalmenuFoodname)
        filtermenufoodprice.addAll(originalMeneuItemPrice)
        filtermenuimage.addAll(originalMenuImage)


        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItem(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItem(newText)
                return true
            }
        })
    }

    private fun filterMenuItem(query: String) {
        filtermenufoodname.clear()
        filtermenufoodprice.clear()
        filtermenuimage.clear()

        originalmenuFoodname.forEachIndexed { index, foodName ->
            if (foodName.contains(query,ignoreCase = true)){
                filtermenufoodname.add(foodName)
                filtermenufoodprice.add(originalMeneuItemPrice[index])
                filtermenuimage.add(originalMenuImage[index])

            }
        }
        adapter.notifyDataSetChanged()

    }

    companion object {

    }
}


