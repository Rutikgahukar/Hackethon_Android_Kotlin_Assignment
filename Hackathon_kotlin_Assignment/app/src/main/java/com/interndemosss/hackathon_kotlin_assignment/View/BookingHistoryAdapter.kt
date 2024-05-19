package com.interndemosss.hackathon_kotlin_assignment.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.interndemosss.hackathon_kotlin_assignment.Model.BookingHistoryResponse
import com.interndemosss.hackathon_kotlin_assignment.R

class BookingHistoryAdapter(private var bookingList: List<BookingHistoryResponse>) : RecyclerView.Adapter<BookingHistoryAdapter.BookingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.booking_sample, parent, false)
        return BookingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        val booking = bookingList[position]
        holder.deskIdValueTextView.text = booking.deskId
        holder.nameValueTextView.text = booking.name
        holder.bookedOnValueTextView.text = booking.bookedOn
    }

    override fun getItemCount(): Int = bookingList.size

    fun updateBookingList(list: List<BookingHistoryResponse>) {
        bookingList = list
        notifyDataSetChanged()
    }

    inner class BookingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val deskIdValueTextView: TextView = itemView.findViewById(R.id.deskIdValueTextView)
        val nameValueTextView: TextView = itemView.findViewById(R.id.nameValueTextView)
        val bookedOnValueTextView: TextView = itemView.findViewById(R.id.bookedOnValueTextView)
    }
}
