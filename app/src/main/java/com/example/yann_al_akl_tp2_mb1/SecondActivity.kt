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
import com.example.yann_al_akl_tp2_mb1.databinding.ActivitySecondBinding
import kotlin.jvm.java

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}