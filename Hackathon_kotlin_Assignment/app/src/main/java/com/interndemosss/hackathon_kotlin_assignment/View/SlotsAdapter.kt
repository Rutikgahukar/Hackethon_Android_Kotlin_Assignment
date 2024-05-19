package com.interndemosss.hackathon_kotlin_assignment.View

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.interndemosss.hackathon_kotlin_assignment.R

class SlotsAdapter : ListAdapter<String, SlotsAdapter.SlotViewHolder>(SlotDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slot_item, parent, false)
        return SlotViewHolder(view)
    }

    override fun onBindViewHolder(holder: SlotViewHolder, position: Int) {
        val slot = getItem(position)
        holder.bind(slot)
    }

    inner class SlotViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        private val timingSlotTextView: TextView = itemView.findViewById(R.id.timingSlotTextView)

        fun bind(slot: String) {
            timingSlotTextView.text = slot
        }
    }

    private class SlotDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}
