package com.example.foodorderapp.Fragements

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodorderapp.Adapters.popularAdapter
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.FragmentHomeBinding
import com.example.foodorderapp.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener


class HomeFragment : Fragment() {
 private lateinit var binding:FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.menuButton.setOnClickListener {
            val bottomDialog = menuBottomSheetFragment()
            bottomDialog.show(parentFragmentManager,"fragment")

        }



        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagelist = ArrayList<SlideModel>()
        imagelist.add(SlideModel(R.drawable.burger, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.pizza, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.fries, ScaleTypes.FIT))

        val imageslide = binding.imageSlider
        imageslide.setImageList(imagelist)
        imageslide.setImageList(imagelist,ScaleTypes.FIT)

        imageslide.setItemClickListener(object:ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemposition = imagelist[position]
                val itemMessage = "Selected image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }

        })
        val foodName = listOf("burger","pizza","fries","burger","pizza","fries")
        val price = listOf("$4","$8","$2","$6","$9","$3")
        val popularFoodImages = listOf(R.drawable.burger,R.drawable.pizza,R.drawable.fries,R.drawable.burger,R.drawable.pizza,R.drawable.fries)

        val adapter = popularAdapter(foodName,popularFoodImages,price,requireContext())
        binding.popularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRecyclerView.adapter = adapter


    }

    companion object {

    }
}