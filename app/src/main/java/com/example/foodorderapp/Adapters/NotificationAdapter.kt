package com.example.foodorderapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderapp.databinding.NotificationItemBinding

class NotificationAdapter(
    private val notifications: List<String>,
    private val notificationImages: List<Int>
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

   inner class NotificationViewHolder(private var binding: NotificationItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
           binding.notificationTextView.text = notifications[position]
            binding.NotificationimageView.setImageResource(notificationImages[position])
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        // Inflate the layout for each item
        val binding = NotificationItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NotificationViewHolder(binding)
    }

    override fun getItemCount(): Int = notifications.size

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)
    }
}
