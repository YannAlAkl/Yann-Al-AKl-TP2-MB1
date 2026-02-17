package com.example.yannalakl_mb1c7_tp2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter(pkmnList: List<pokemonModels>) : RecyclerView.Adapter<PokemonAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_pokemon, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        //val currentPokemon = pokemonList[position]
    }

    override fun getItemCount(): Int {
        //return pokemonList.size
        return 4
    }
}
