package com.example.foodorderapp.Fragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.Adapters.BuyAgainAdapter
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.FragmentHistryBinding


class HistryFragment : Fragment() {

private lateinit var binding: FragmentHistryBinding
private lateinit var adapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistryBinding.inflate(layoutInflater,container,false)
        setUpRecyclerView()
        return binding.root
    }

    protected fun setUpRecyclerView(){
        val buyAgainFoodName = arrayListOf("food","food2","food3","food4")
        val buyAgainFoodPrice = arrayListOf("$6","$9","$3","$9")
        val buyAgainFoodImage = arrayListOf(R.drawable.food_res,R.drawable.pizza,R.drawable.burger,R.drawable.fries,R.drawable.burger)

        adapter = BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.BuyAgainRecyclerView.adapter = adapter
        binding.BuyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())


    }

    companion object {

    }
}