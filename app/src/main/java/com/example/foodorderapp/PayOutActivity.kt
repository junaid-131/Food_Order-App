package com.example.foodorderapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodorderapp.Fragements.CongratsbottomsheetFragment
import com.example.foodorderapp.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    private  val binding:ActivityPayOutBinding by lazy {
        ActivityPayOutBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.placeorderbutton.setOnClickListener{
            val bottomSheetDialog = CongratsbottomsheetFragment()
            bottomSheetDialog.show(supportFragmentManager,"fragment")
        }

    }
}