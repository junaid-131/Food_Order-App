package com.example.foodorderapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderapp.databinding.BuyAgainItemBinding
import kotlin.contracts.contract

class BuyAgainAdapter(
    private val buyAgainFoodNeme: ArrayList<String>,
    private val buyAgainFoodPrice: ArrayList<String>,
    private val buyAgainFoodImage: ArrayList<Int>
):RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {
    class BuyAgainViewHolder(private val binding:BuyAgainItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(foodName: String, foodPrice: String, foodImage: Int) {
            binding.BuyAgainFoodName.text = foodName
            binding.BuyAgainFoodPrice.text = foodPrice
            binding.BuyAgainFoodImage.setImageResource(foodImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }
    override fun getItemCount():Int = buyAgainFoodNeme.size

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(buyAgainFoodNeme[position],buyAgainFoodPrice[position],buyAgainFoodImage[position])
    }
}