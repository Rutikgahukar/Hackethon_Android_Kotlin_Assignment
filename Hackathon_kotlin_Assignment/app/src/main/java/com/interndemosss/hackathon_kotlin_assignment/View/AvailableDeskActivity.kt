package com.interndemosss.hackathon_kotlin_assignment.View

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.interndemosss.hackathon_kotlin_assignment.R
import com.interndemosss.hackathon_kotlin_assignment.ViewModel.BookingViewModel
import com.interndemosss.hackathon_kotlin_assignment.ViewModel.DeskAvailabilityViewModel
import com.interndemosss.hackathon_kotlin_assignment.databinding.ActivityAvailableDeskBinding
import com.interndemosss.hackathon_kotlin_assignment.databinding.PopupConfirmBookingBinding

class AvailableDeskActivity : AppCompatActivity() {
    private lateinit var viewModel: DeskAvailabilityViewModel
    private lateinit var adapter: DeskAdapter
    private lateinit var binding: ActivityAvailableDeskBinding
    private lateinit var bookingViewModel: BookingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvailableDeskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this).get(DeskAvailabilityViewModel::class.java)
        bookingViewModel = ViewModelProvider(this)[BookingViewModel::class.java]

        // Initialize RecyclerView and Adapter
        binding.DeskrecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DeskAdapter()
        binding.DeskrecyclerView.adapter = adapter

        // Observe LiveData from ViewModel
        viewModel.availableDesks.observe(this) { desks ->
            adapter.updateDeskList(desks)
        }

        // Fetch available desks
        val date = "2023-05-01" // Change as needed
        val slotId = 2 // Change as needed
        val type = 1 // Change as needed
        viewModel.fetchAvailableDesks(date, slotId, type)

        binding.BookDeskButton.setOnClickListener {
            showBookingPopup()
        }
    }

    private fun showBookingPopup() {
        val popupBinding = PopupConfirmBookingBinding.inflate(LayoutInflater.from(this))
        val dialog = AlertDialog.Builder(this)
            .setView(popupBinding.root)
            .create()

        popupBinding.btnConfirm.setOnClickListener {
            val date = "2023-05-01"
            val slotId = 2
            val workspaceId = 3
            val type = 1

            bookingViewModel.confirmBooking(date, slotId, workspaceId, type) { response ->
                if (response.isSuccessful) {
                    Toast.makeText(this, "Booking confirmed successfully!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to confirm booking.", Toast.LENGTH_SHORT).show()
                }
                dialog.dismiss()
            }
        }

        dialog.show()
    }
}
