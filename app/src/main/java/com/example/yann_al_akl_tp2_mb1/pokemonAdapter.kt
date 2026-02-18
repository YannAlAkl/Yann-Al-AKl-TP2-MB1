package com.example.yann_al_akl_tp2_mb1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yann_al_akl_tp2_mb1.R

class PokemonAdapter(private val pkmnList: List<PokemonResult>) : RecyclerView.Adapter<PokemonAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_pokemon, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val currentPokemon = pkmnList[position]
    }

    override fun getItemCount(): Int {
        return pkmnList.size
    }
}
