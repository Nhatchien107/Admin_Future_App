package com.example.adminfutureapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adminfutureapp.databinding.ActivityAdminFrofileBinding

class AdminFrofileActivity : AppCompatActivity() {
    private val binding : ActivityAdminFrofileBinding by lazy {
        ActivityAdminFrofileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
        }
        binding.name.isEnabled = false
        binding.adress.isEnabled = false
        binding.email.isEnabled = false
        binding.phone.isEnabled = false
        binding.password.isEnabled = false

        var isEnable = false
        binding.editButton.setOnClickListener{
            isEnable = !isEnable
            binding.name.isEnabled = isEnable
            binding.adress.isEnabled = isEnable
            binding.email.isEnabled = isEnable
            binding.phone.isEnabled = isEnable
            binding.password.isEnabled = isEnable
            if (isEnable){
                binding.name.requestFocus()
            }
        }
    }
}