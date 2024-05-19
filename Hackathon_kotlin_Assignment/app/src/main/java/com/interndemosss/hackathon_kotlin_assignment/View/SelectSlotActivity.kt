package com.interndemosss.hackathon_kotlin_assignment.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.interndemosss.hackathon_kotlin_assignment.R
import com.interndemosss.hackathon_kotlin_assignment.ViewModel.SlotViewModel
import com.interndemosss.hackathon_kotlin_assignment.databinding.ActivitySelectSlotAcitivityBinding

class SelectSlotActivity : AppCompatActivity() {
    private lateinit var viewModel: SlotViewModel
    private lateinit var slotsAdapter: SlotsAdapter
    private lateinit var binding: ActivitySelectSlotAcitivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_slot_acitivity)

        viewModel = ViewModelProvider(this)[SlotViewModel::class.java]

        // Fetch slots for a specific date
        val date = "2023-05-01" // Change date as needed
        viewModel.fetchSlots(date)

        val recyclerView: RecyclerView = findViewById(R.id.fetchrecyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        slotsAdapter = SlotsAdapter()
        recyclerView.adapter = slotsAdapter

        viewModel.slots.observe(this, Observer { slots ->
            // Update UI with fetched slots
            slotsAdapter.submitList(slots)
        })

        binding.SelectSlotsNextButton.setOnClickListener {
            val intent = Intent(this, AvailableDeskActivity::class.java)
            startActivity(intent)
        }

    }
}
