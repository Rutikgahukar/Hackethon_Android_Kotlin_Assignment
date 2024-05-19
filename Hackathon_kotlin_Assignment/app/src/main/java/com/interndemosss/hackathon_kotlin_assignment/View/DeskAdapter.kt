package com.interndemosss.hackathon_kotlin_assignment.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.interndemosss.hackathon_kotlin_assignment.Model.Desk
import com.interndemosss.hackathon_kotlin_assignment.Model.DeskAvailabilityResponse
import com.interndemosss.hackathon_kotlin_assignment.R

class DeskAdapter : RecyclerView.Adapter<DeskAdapter.DeskViewHolder>() {

    private var deskList: List<Desk> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.desk_item_layout, parent, false)
        return DeskViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeskViewHolder, position: Int) {
        val desk = deskList[position]
        holder.deskIdTextView.text = desk.deskId
        generateSlots(holder.gridLayout, desk.availabilityStatusList)
    }

    private fun generateSlots(gridLayout: GridLayout, availabilityStatusList: List<Boolean>) {
        gridLayout.removeAllViews()
        availabilityStatusList.forEachIndexed { index, available ->
            val slotTextView = TextView(gridLayout.context)
            slotTextView.layoutParams = GridLayout.LayoutParams().apply {
                width = GridLayout.LayoutParams.WRAP_CONTENT
                height = GridLayout.LayoutParams.WRAP_CONTENT
            }
            slotTextView.gravity = android.view.Gravity.CENTER
            slotTextView.text = (index + 1).toString()
            slotTextView.setBackgroundResource(if (available) R.drawable.available_slot_background else R.drawable.booked_unavailable_slot_background)
            gridLayout.addView(slotTextView)
        }
    }

    override fun getItemCount(): Int = deskList.size

    fun updateDeskList(list: List<DeskAvailabilityResponse>) {
        deskList = list.map { Desk(it.deskId.toString(), listOf(it.availability)) }
        notifyDataSetChanged()
    }

    inner class DeskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val deskIdTextView: TextView = itemView.findViewById(R.id.deskIdTextView)
        val gridLayout: GridLayout = itemView.findViewById(R.id.gridLayout)
    }
}
