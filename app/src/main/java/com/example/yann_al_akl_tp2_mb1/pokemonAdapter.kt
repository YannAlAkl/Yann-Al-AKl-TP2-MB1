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

    override fun onBindViewHolder(holder: VH, position: Int) {
        val p = list[position]
        holder.binding.tvName.text = p.name
        holder.binding.tvNumber.text = p.national_number
        holder.binding.tvTypes.text = p.type.joinToString(", ")
        holder.binding.tvHP.text = p.hp.toString()
        holder.binding.tvAttack.text = p.attack.toString()
        holder.binding.tvDefense.text = p.defense.toString()
        holder.binding.tvSpAtk.text = p.sp_atk.toString()
        holder.binding.tvSpDef.text = p.sp_def.toString()
        holder.binding.tvSpeed.text = p.speed.toString()
        holder.binding.tvTotal.text = p.total.toString()
        holder.binding.ivPokemon.load(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${p.national_number}.png"
        )
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