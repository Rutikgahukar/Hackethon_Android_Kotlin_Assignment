package com.interndemosss.hackathon_kotlin_assignment.View

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import android.content.Intent
import android.widget.TextView
import com.interndemosss.hackathon_kotlin_assignment.R
import com.interndemosss.hackathon_kotlin_assignment.ViewModel.HomeViewModel
import com.interndemosss.hackathon_kotlin_assignment.databinding.ActivityBookingHistoryBinding
import io.opentelemetry.sdk.metrics.View


class HomeActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val workStationLayout = findViewById<LinearLayout>(R.id.workStationLayout)
        val meetingRoomLayout = findViewById<LinearLayout>(R.id.MeetingRoomLayout)
        val bookingHistoryButton: TextView = findViewById(R.id.BookingHistoryButton)


        viewModel.selectedBackground.observe(this, Observer { background ->
            workStationLayout.setBackgroundResource(R.drawable.fent_back)
            meetingRoomLayout.setBackgroundResource(R.drawable.fent_back)
            findViewById<LinearLayout>(background).setBackgroundResource(R.drawable.button_background)
        })

        workStationLayout.setOnClickListener {
            viewModel.setSelectedBackground(R.id.workStationLayout)
            val intent = Intent(this, SelectSlotActivity::class.java)
            startActivity(intent)
        }

        meetingRoomLayout.setOnClickListener {
            viewModel.setSelectedBackground(R.id.MeetingRoomLayout)
            val intent = Intent(this, SelectSlotActivity::class.java)
            startActivity(intent)
        }

        bookingHistoryButton.setOnClickListener {
            val intent = Intent(this, ActivityBookingHistoryBinding::class.java)
            startActivity(intent)
        }
    }
}
