package com.example.foodorderapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderapp.DetailActivity
import com.example.foodorderapp.databinding.MenuItemBinding

class menuAdapter(private val menuItem: List<String>, private val menuItemPrice: List<String>, private val menuItemImage: List<Int>,private val context:Context):RecyclerView.Adapter<menuAdapter.menuViewHolder>() {
    private val onItemClickListener: OnItemClickListener ?= null
  inner  class menuViewHolder(private val binding: MenuItemBinding):RecyclerView.ViewHolder(binding.root) {
      init {
          binding.root.setOnClickListener {
              val position = adapterPosition
              if (position != RecyclerView.NO_POSITION) {

                  onItemClickListener?.onItemClick(position)
              }
              val intent = Intent(context, DetailActivity::class.java)
              intent.putExtra("menuItem", menuItem[position])
              intent.putExtra("menuItemImage", menuItemImage[position])
              context.startActivity(intent)
          }
      }
        fun bind(position: Int) {
            binding.apply {
                MenuFoodName.text = menuItem[position]
                menuFoodPrice.text = menuItemPrice[position]
                menuImage.setImageResource(menuItemImage[position])


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): menuViewHolder {
        val binding= MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return menuViewHolder(binding)

    }


    override fun getItemCount(): Int {
        return menuItem.size
    }

    override fun onBindViewHolder(holder: menuViewHolder, position: Int) {
        holder.bind(position)

        holder.itemView.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("menuItem", menuItem[position])
            intent.putExtra("menuItemImage", menuItemImage[position])
            context.startActivity(intent)
        }
    }

}

private fun Any?.onItemClick(position: Int) {

}
