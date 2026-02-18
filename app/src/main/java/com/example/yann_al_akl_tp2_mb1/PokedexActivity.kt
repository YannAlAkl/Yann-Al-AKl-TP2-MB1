package com.example.yann_al_akl_tp2_mb1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yann_al_akl_tp2_mb1.databinding.ActivityPokedexBinding
import com.google.gson.Gson

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class PokedexActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokedexBinding
    private val list = mutableListOf<PokemonResult>()
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PokemonAdapter(list)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        loadPokemon()
    }

    private fun loadPokemon() {
        binding.progressBar.visibility = View.VISIBLE

        lifecycleScope.launch {
            try {
                val response: PokemonResponse = withContext(Dispatchers.IO) {
                    val json = URL("https://pokeapi.co/api/v2/pokemon?limit=20").readText()
                    Gson().fromJson(json, PokemonResponse::class.java)   // IMPORTANT: last line = returned value
                }

                adapter.updateData(response.results)

            } catch (e: Exception) {
                Toast.makeText(this@PokedexActivity, "Erreur API", Toast.LENGTH_SHORT).show()
            } finally {
                binding.progressBar.visibility = View.GONE
            }
        }
    }

}
