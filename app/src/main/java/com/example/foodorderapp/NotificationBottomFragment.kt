package com.example.foodorderapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderapp.Adapters.NotificationAdapter
import com.example.foodorderapp.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotificationBottomFragment : BottomSheetDialogFragment() {
private lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater,container,false)
        val notification = listOf("notification 1","notification 2" , "notification 3")
        val notificationImage = listOf(R.drawable.notification,R.drawable.notification,R.drawable.notification)

        val adapter = NotificationAdapter(notification,notificationImage)


    binding.notificationRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerview.adapter = adapter

        return binding.root
    }

    companion object {

    }
}