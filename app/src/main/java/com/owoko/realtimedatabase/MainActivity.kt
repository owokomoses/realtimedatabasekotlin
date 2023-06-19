package com.owoko.realtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.owoko.realtimedatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val firstName = binding.firstname.text.toString()
            val lastName = binding.lastname.text.toString()
            val age = binding.age.text.toString()
            val username=binding.username.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val user = User(firstName,lastName,age,username)
            database.child("userName").setValue(user).addOnSuccessListener {

                binding.firstname.text.clear()
                binding.lastname.text.clear()
                binding.age.text.clear()
                binding.username.text.clear()

                Toast.makeText(this,"Successfully saved",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{

                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()

            }
        }
    }
}