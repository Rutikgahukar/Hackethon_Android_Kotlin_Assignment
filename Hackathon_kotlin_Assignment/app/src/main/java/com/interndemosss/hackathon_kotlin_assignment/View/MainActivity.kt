package com.interndemosss.hackathon_kotlin_assignment.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.interndemosss.hackathon_kotlin_assignment.R
import com.interndemosss.hackathon_kotlin_assignment.ViewModel.LoginViewModel
import com.interndemosss.hackathon_kotlin_assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginButton.setOnClickListener {
            val email = binding.LoginNOorEmail.text.toString()
            val password = binding.LoginPassword.text.toString()
            viewModel.login(email, password) { isSuccess ->
                if (isSuccess) {
                    showToast("Login successfully")
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    showToast("Login failed")
                }
            }
        }
        binding.TxtCreateAc.setOnClickListener {
            // Navigate to CreateAccontActivity
            val intent = Intent(this, CreateAccontActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
