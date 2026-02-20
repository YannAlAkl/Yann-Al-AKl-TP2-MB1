package com.example.yann_al_akl_tp2_mb1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yann_al_akl_tp2_mb1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        binding.btnConnect.setOnClickListener {
            verifyLogin()
        }
        binding.tvNewUser.setOnClickListener {
            gotoSecondActivity()
        }
        binding.tvChangePass.setOnClickListener {
            gotoChangePassword()
        }
    }
    private fun verifyLogin() {
        val user = binding.etUsername.text.toString().trim()
        val pass = binding.etPassword.text.toString().trim()

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Champs vides", Toast.LENGTH_SHORT).show()
        } else if (!userExists(user, pass)) {
            Toast.makeText(this, "Utilisateur non trouvé", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Connexion réussie", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, PokedexActivity::class.java))
        }

    }

    private fun userExists(user: String, pass: String): Boolean {
        val saveUser= sharedPreferences.getString("last_user", null)
        val savedPass = sharedPreferences.getString(saveUser, null)
        return saveUser != null && savedPass != null && saveUser == user && savedPass == pass
    }

    private fun gotoSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
    private fun gotoChangePassword() {
        val intent = Intent(this, ChangePassword::class.java)
        startActivity(intent)
    }
}

