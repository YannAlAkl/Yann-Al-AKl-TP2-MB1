package com.example.yann_al_akl_tp2_mb1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.yann_al_akl_tp2_mb1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        binding.btnInscription.setOnClickListener {
            setUpUser()
        }
    }
    private fun setUpUser() {
        val user = binding.etUsername.text.toString().trim()
        val pass = binding.etPass.text.toString().trim()
        val confirmPass = binding.etConfirmPass.text.toString().trim()
        if (user.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
            Toast.makeText(this, "Champs vides", Toast.LENGTH_SHORT).show()
            return
        }

        if (pass != confirmPass) {
            Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT)
                .show()
            return
        }

        if (userExists(user)) {
            Toast.makeText(this, "L'utilisateur existe déjà", Toast.LENGTH_SHORT).show()
        } else {
            saveUserToPrefs(user, pass)
            Toast.makeText(this, "Utilisateur créé !", Toast.LENGTH_SHORT).show()
            gotoMainActivity()
        }
    }
    private fun saveUserToPrefs(user: String, pass: String) {
        sharedPreferences.edit {
            putString(user, pass)
            putString("last_user", user)
            apply()
        }
    }
    private fun userExists(user: String): Boolean {
        return sharedPreferences.contains(user)
    }
    private fun gotoMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}