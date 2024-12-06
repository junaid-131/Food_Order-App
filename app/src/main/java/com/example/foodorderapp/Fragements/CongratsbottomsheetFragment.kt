package com.example.foodorderapp.Fragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodorderapp.R
import com.example.foodorderapp.databinding.FragmentCongratsbottomsheetBinding
import com.example.foodorderapp.databinding.FragmentHistryBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CongratsbottomsheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentCongratsbottomsheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCongratsbottomsheetBinding.inflate(inflater,container,false)




        return binding.root

    }

    companion object {

    }
}