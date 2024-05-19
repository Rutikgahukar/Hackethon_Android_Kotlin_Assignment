package com.interndemosss.hackathon_kotlin_assignment.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.interndemosss.hackathon_kotlin_assignment.R
import com.interndemosss.hackathon_kotlin_assignment.ViewModel.CreateAccountViewModel
import com.interndemosss.hackathon_kotlin_assignment.databinding.ActivityCreateAccountBinding

class CreateAccontActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding
    private lateinit var viewModel: CreateAccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this).get(CreateAccountViewModel::class.java)

        binding.CreateAcButton.setOnClickListener {
            val name = binding.CreateAcFullName.text.toString().trim()
            val email = binding.CreateEmailID.text.toString().trim()
            val mobileNumber = binding.CreateAcMobileNo.text.toString().trim()

            if (name.isEmpty() || email.isEmpty()||mobileNumber.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.createAccount(email, name)
            }
        }

        viewModel.createAccountResponse.observe(this, { response ->
            // Check if the response is not null
            response?.let {
                if (it.status == "Success") {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
                } else {
                    // Access the message property instead of errorMessage
                    Toast.makeText(this, "Failed to create account: ${it.getErrorMessage()}", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.BackLoginActivity.setOnClickListener {
            // Navigate to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}