package com.example.utslabmdhafin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PopularAdapter(private val popularList : ArrayList<Popular>) :
    RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    class PopularViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
        val popularImageView : ImageView = itemView.findViewById(R.id.imageView_popularExercise)
        val popularNameTv : TextView = itemView.findViewById(R.id.textview_popular)
        val popularMinTv : TextView = itemView.findViewById(R.id.textviewMin_popular)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_popular_exercise , parent , false)
        return PopularViewHolder(view)
    }

    override fun getItemCount(): Int {
        return popularList.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val category = popularList[position]
        holder.popularImageView.setImageResource(category.PopularImage)
        holder.popularNameTv.text = category.PopularName
        holder.popularMinTv.text = category.PopularMin
    }
}