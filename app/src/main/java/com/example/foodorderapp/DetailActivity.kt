package com.example.foodorderapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodorderapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val foodname = intent.getStringExtra("menuItem")
        val foodimage = intent.getIntExtra("menuItemImage", 0)

        binding.detailfoodname.text = foodname
        binding.detailfoodimage.setImageResource(foodimage)

        binding.imageButton.setOnClickListener {
            finish()
        }

    }
}