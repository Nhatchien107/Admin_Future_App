package com.example.adminfutureapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminfutureapp.adapter.MenuItemAdapter
import com.example.adminfutureapp.databinding.ActivityAlliteemBinding
import com.example.adminfutureapp.model.AllMenu
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AllItemActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private  var menuItems : ArrayList<AllMenu> = ArrayList()
    private val binding : ActivityAlliteemBinding by lazy {
      ActivityAlliteemBinding.inflate(layoutInflater)
  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        databaseReference = FirebaseDatabase.getInstance().reference
        retrieveMenuItem()
        binding.backButton.setOnClickListener {
            finish()
        }
    }



    private fun retrieveMenuItem() {
       database = FirebaseDatabase.getInstance()
        val foodRef : DatabaseReference =  database.reference.child("menu")

        //lấy dữ liệu từ cơ sở dữ liệu
        foodRef.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               //Xóa dữ liệu hiện có trước khi điền
                menuItems.clear()
                //lặp qua từng món ăn
                for(foodSnapshot in snapshot.children){
                    val menuItem = foodSnapshot.getValue(AllMenu::class.java)
                    menuItem?.let{
                        menuItems.add(it)
                    }
                }
                setAdapter()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Database Error", "Error : ${error.message} ")
            }
        })
    }

    private fun setAdapter() {
        val adapter = MenuItemAdapter(this@AllItemActivity,menuItems,databaseReference)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.menuRecyclerView.adapter = adapter

        }
    }


