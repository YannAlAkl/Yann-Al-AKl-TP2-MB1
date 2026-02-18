package com.example.yann_al_akl_tp2_mb1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

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
        holder.binding.tvUrl.text = p.url
    }

    fun updateData(newList: List<PokemonResult>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}
