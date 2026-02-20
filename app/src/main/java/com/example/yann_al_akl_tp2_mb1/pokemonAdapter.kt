package com.example.yann_al_akl_tp2_mb1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.yann_al_akl_tp2_mb1.databinding.TemplatePokemonBinding

class PokemonAdapter(private val list: MutableList<PokemonResult>) :
    RecyclerView.Adapter<PokemonAdapter.VH>() {

    class VH(val binding: TemplatePokemonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = TemplatePokemonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VH(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: VH, position: Int) {
        val p = list[position]
        holder.binding.tvName.text = p.name
        holder.binding.tvNumber.text = p.national_number
        holder.binding.tvTypes.text = p.type.joinToString(", ")
        holder.binding.tvHP.text = "HP: ${p.hp}"
        holder.binding.tvAttack.text = "Attack: ${p.attack}"
        holder.binding.tvDefense.text = "Defense: ${p.defense}"
        holder.binding.tvSpAtk.text = "Sp.Atk: ${ p.sp_atk}"
        holder.binding.tvSpDef.text = "Sp.Def: ${p.sp_def}"
        holder.binding.tvSpeed.text = "Speed: ${p.speed}"
        holder.binding.tvTotal.text = "Total: ${p.total}"
        
        // Main image
        holder.binding.ivPokemon.load(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${p.national_number}.png"
        )
        
        // Large and animated sprites (using safe calls to handle null sprites)
        holder.binding.ivLarge.load(p.sprites?.large)
        holder.binding.ivAnimated.load(p.sprites?.animated)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<PokemonResult>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}
