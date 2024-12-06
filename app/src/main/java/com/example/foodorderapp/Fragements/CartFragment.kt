package com.example.foodorderapp.Fragements

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.Adapters.CartAdapter
import com.example.foodorderapp.PayOutActivity
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.FragmentCartBinding



class CartFragment : Fragment() {

private lateinit var  binding:FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentCartBinding.inflate(inflater,container,false)



        val cartfoodName = listOf("burger","pizza","fries","burger","pizza","fries")
        val cartitemPrice = listOf("$6","$9","$3","$6","$9","$3")
        val cartimage = listOf(R.drawable.burger,R.drawable.pizza,R.drawable.fries,R.drawable.burger,R.drawable.pizza,R.drawable.fries)

        val adapter = CartAdapter(ArrayList(cartfoodName),ArrayList(cartitemPrice),ArrayList(cartimage))
        binding.cartRecycerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecycerView.adapter=adapter

        
        binding.proceedbutton.setOnClickListener{
            val intent =Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }


        return binding.root
    }



    companion object {

    }
}