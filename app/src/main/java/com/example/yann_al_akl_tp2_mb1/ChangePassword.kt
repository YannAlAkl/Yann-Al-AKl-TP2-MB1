package com.example.yann_al_akl_tp2_mb1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yann_al_akl_tp2_mb1.databinding.ActivityChangePasswordBinding
import androidx.core.content.edit

class ChangePassword : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSavePassword.setOnClickListener {
            restPassword()
        }
    }
    private fun restPassword() {
        val user = binding.etInputUsername.text.toString().trim()
        val newPass = binding.etNewPassword.text.toString().trim()
        val confirmNewPass = binding.etConfirmNewPassword.text.toString().trim()
        if (user.isEmpty() || newPass.isEmpty() || confirmNewPass.isEmpty()) {
            Toast.makeText(this, "Champs vides", Toast.LENGTH_SHORT).show()
        } else if (newPass != confirmNewPass) {
            Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT)
                .show()
        } else {
            saveNewPass(user, newPass)
            Toast.makeText(this, "Mot de passe modifié !", Toast.LENGTH_SHORT).show()
            goToMainActivity()
        }
    }
    private fun saveNewPass(user: String, newPass: String) {
        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit {
            putString(user, newPass)
        }
    }
    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}