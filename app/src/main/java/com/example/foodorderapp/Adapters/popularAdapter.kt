package com.example.foodorderapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderapp.DetailActivity
import com.example.foodorderapp.databinding.PopularItemBinding



class popularAdapter(private val items:List<String>,private val image:List<Int>,private val price: List<String>,private val context: Context):RecyclerView.Adapter<popularAdapter.popularViewHolder>() {
    class popularViewHolder(val binding: PopularItemBinding):RecyclerView.ViewHolder(binding.root) {
        val imageView = binding.imageView5
        fun bind(item: String, image: Int, price: String) {
            binding.popularFoodName.text = item
            binding.popularPrice.text = price
            imageView.setImageResource(image)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): popularViewHolder {
        return popularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: popularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]

        holder.bind(item,images,price)


        holder.itemView.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("menuItem", items[position])
            intent.putExtra("menuItemImage", image[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}