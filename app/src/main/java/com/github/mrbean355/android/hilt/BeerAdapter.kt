package com.github.mrbean355.android.hilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.mrbean355.android.hilt.service.Beer

class BeerAdapter : ListAdapter<Beer, BeerAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_beer, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beer = getItem(position)
        Glide.with(holder.image)
            .load(beer.image_url)
            .into(holder.image)
        holder.name.text = beer.name
        holder.tagLine.text = beer.tagline
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.beer_image)
        val name: TextView = itemView.findViewById(R.id.beer_name)
        val tagLine: TextView = itemView.findViewById(R.id.beer_tag_line)
    }

    class DiffCallback : DiffUtil.ItemCallback<Beer>() {
        override fun areItemsTheSame(oldItem: Beer, newItem: Beer) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Beer, newItem: Beer) = oldItem == newItem
    }
}