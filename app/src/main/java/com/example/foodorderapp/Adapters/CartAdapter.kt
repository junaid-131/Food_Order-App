package com.example.foodorderapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderapp.databinding.CartItemBinding

class CartAdapter(private val cartItems:MutableList<String>, private val cartItemPrice:MutableList<String>,private val CartImage:MutableList<Int>):RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private val itemQuantity = IntArray(cartItems.size){1}
   inner class CartViewHolder(private val binding:CartItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity= itemQuantity[position]
                CartFoodName.text = cartItems[position]
                CartPrice.text = cartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                CartItemNumber.text = quantity.toString()

            cartNegative.setOnClickListener{
                if (itemQuantity[position]>1){
                    itemQuantity[position]--
                    binding.CartItemNumber.text = itemQuantity[position].toString()
                }
            }
                CartPlus.setOnClickListener{
                    if (itemQuantity[position]<10){
                        itemQuantity[position]++
                        binding.CartItemNumber.text = itemQuantity[position].toString()
                    }
                }
                CartDelete.setOnClickListener {
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        cartItems.removeAt(position)
                        cartItemPrice.removeAt(position)
                        CartImage.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeChanged(position, cartItems.size)
                    }
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun getItemCount(): Int {
      return  cartItems.size
    }
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }



}