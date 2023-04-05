package com.biniyam.firebaseemailloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.biniyam.firebaseemailloginapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.FirebaseAuthKtxRegistrar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var  binding: ActivityMainBinding

    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = Firebase.auth

        binding.btnRegister.setOnClickListener {
            registerUser()
        }

        binding.btnLogin.setOnClickListener {
            loginUser()
        }
    }

    private fun registerUser() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {

                Toast.makeText(this, "sucessfully registered!",Toast.LENGTH_SHORT).show()

            }
            .addOnFailureListener {

                Toast.makeText(this, "registration failed!",Toast.LENGTH_SHORT).show()

            }
    }

    private fun loginUser() {

        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
               binding.etEmail.text.clear()
               binding.etPassword.text.clear()
                startActivity(Intent(this, NewActivity::class.java))

            }
            .addOnFailureListener {
                Toast.makeText(this, "registration failed!",Toast.LENGTH_SHORT).show()
            }
    }
}