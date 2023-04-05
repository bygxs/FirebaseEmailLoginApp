package com.biniyam.firebaseemailloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.biniyam.firebaseemailloginapp.databinding.ActivityNewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class NewActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewBinding.inflate(layoutInflater)

        setContentView(binding.root)


        firebaseAuth = Firebase.auth

        val user = firebaseAuth.currentUser

        binding.tvMail.text = user?.email
        binding.tvUserId.text = user?.uid

        binding.btnLogout.setOnClickListener {
            firebaseAuth.signOut()
            finish()
        }





    }
}