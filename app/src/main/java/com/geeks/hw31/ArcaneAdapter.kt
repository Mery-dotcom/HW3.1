package com.geeks.hw31

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geeks.hw31.databinding.ItemArcaneBinding

class ArcaneAdapter(
    private val arcaneList: ArrayList<Arcane>,
    private val onItemClick: (position: Int) -> Unit):
    RecyclerView.Adapter<ArcaneAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemArcaneBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(arcane: Arcane) = with(binding){
            txtName.text = arcane.name
            Glide.with(ivArcane).load(arcane.image).into(ivArcane)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(
           ItemArcaneBinding.inflate(
               LayoutInflater.from(parent.context),
               parent,
               false
           )
       )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arcaneList[position])
        holder.itemView.setOnClickListener{
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int = arcaneList.size
}