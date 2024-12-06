package com.example.foodorderapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodorderapp.Fragements.menuBottomSheetFragment
import com.example.foodorderapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Set up the BottomNavigationView with NavController
        val navController = findNavController(R.id.fragmentContainerView4)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView2)
        bottomNav.setupWithNavController(navController)

        // Show BottomSheetDialogFragment on notification button click
        binding.notificationButton.setOnClickListener {
           val bottomSheetDialog = NotificationBottomFragment()
            bottomSheetDialog.show(supportFragmentManager,"fragment")


        }
    }
}
