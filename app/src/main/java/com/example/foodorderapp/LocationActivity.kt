package com.example.foodorderapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.foodorderapp.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {
    private val binding:ActivityLocationBinding by lazy {
        ActivityLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val arraylist = arrayOf("Multan","karachi","Lahore","Faisalabad")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,arraylist)
        val autoCompleteTextView = binding.Listoflocation
        autoCompleteTextView.setAdapter(adapter)
    }
}