package com.interndemosss.mvvmarchitecture.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.interndemosss.mvvmarchitecture.R
import com.interndemosss.mvvmarchitecture.databinding.ActivityMainBinding
import com.interndemosss.mvvmarchitecture.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {

    private val model : CityViewModel by viewModels()
    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()

        model.getCityData().observe(this, Observer {
            city -> binding.cityImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources,city.img,applicationContext.theme)
            )
            binding.cityNameTV.text = city.population.toString()
        })
    }
}