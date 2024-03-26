package com.example.adminfutureapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminfutureapp.adapter.DeliveryAdapter
import com.example.adminfutureapp.adapter.PendingOrderAdapter
import com.example.adminfutureapp.databinding.ActivityPendingOrderBinding
import com.example.adminfutureapp.databinding.PendingOrdersItemBinding

class PendingOrderActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPendingOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPendingOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener{
            finish()
        }
        val orderedCustomerName = arrayListOf(
            "Meme",
            "Doan Chi Binh",
            "Cloud",
        )
        val orderedQuantity = arrayListOf(
            "8",
            "7",
            "6",
        )
        val orderedFoodImage = arrayListOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,)
        val adapter = PendingOrderAdapter(orderedCustomerName,orderedQuantity,orderedFoodImage, this)
        binding.pendingOrderRecyclerView.adapter = adapter
        binding.pendingOrderRecyclerView.layoutManager= LinearLayoutManager(this)
    }
    }
