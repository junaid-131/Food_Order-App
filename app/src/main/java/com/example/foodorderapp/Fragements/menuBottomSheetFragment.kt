package com.example.foodorderapp.Fragements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.Adapters.menuAdapter
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class menuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var  binding:FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        val menufoodName = listOf("burger","pizza","fries")
        val menuitemPrice = listOf("$6","$9","$3")
        val menuimage = listOf(R.drawable.burger,R.drawable.pizza,R.drawable.fries)

        val adapter = menuAdapter(ArrayList(menufoodName),ArrayList(menuitemPrice),ArrayList(menuimage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter



        binding.buttonBack.setOnClickListener {
            dismiss()
        }


        return binding.root
    }

    companion object {

    }

}