package com.anoddyne.fishapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class FishAdapter(private val fishList: List<FishData>) :
    RecyclerView.Adapter<FishAdapter.FishViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishViewHolder = FishViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
    )

    override fun onBindViewHolder(holder: FishViewHolder, position: Int) {
        val fish = fishList[position]
        Picasso.get()
            .load(fish.image)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.image1)
            .into(holder.image)
        holder.name.text = fish.name
        holder.description.text = fish.description
    }

    override fun getItemCount(): Int = fishList.size

    class FishViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_view)
        val name: TextView = view.findViewById(R.id.tv_name)
        val description: TextView = view.findViewById(R.id.tv_description)
    }
}