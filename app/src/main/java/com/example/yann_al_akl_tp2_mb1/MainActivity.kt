package com.example.yann_al_akl_tp2_mb1

import android.app.Activity
import android.os.Bundle
import com.example.yann_al_akl_tp2_mb1.databinding.ActivityMainBinding
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.core.content.edit
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvNewUser.setOnClickListener {
            setUpUser()
        }
        binding.btnConnect.setOnClickListener {
            verifyLogin()
        }
    }

    private fun setUpUser() {
        val user = binding.etUsername.text.toString().trim()
        val pass = binding.etPassword.text.toString().trim()

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Champs vides", Toast.LENGTH_SHORT).show()
        } else if (userExists(user)) {
            Toast.makeText(this, "L'utilisateur existe déjà", Toast.LENGTH_SHORT).show()
        } else {
            saveUserToPrefs(user, pass)
            Toast.makeText(this, "Utilisateur créé !", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveUserToPrefs(user: String, pass: String) {
        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit {
            putString(user, pass)
        }
    }

    private fun userExists(user: String): Boolean {
        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.contains(user)
    }

    private fun verifyLogin() {
        val user = binding.etUsername.text.toString().trim()
        val pass = binding.etPassword.text.toString().trim()
        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Champs vides", Toast.LENGTH_SHORT).show()
        if (userExists(user)) {
            gotoSecondActivity()
        }
        }
    }
    private fun gotoSecondActivity() {
        // Remplace "DataActivity" par le nom de ta deuxième activité
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
