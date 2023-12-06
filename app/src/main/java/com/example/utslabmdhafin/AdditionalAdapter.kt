package com.example.utslabmdhafin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdditionalAdapter(private val additionalList : ArrayList<Additional>) :
    RecyclerView.Adapter<AdditionalAdapter.AdditionalViewHolder>() {

    class AdditionalViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
        val addtionalImageView : ImageView = itemView.findViewById(R.id.imageView_additional)
        val addtionalImageViewBack : ImageView = itemView.findViewById(R.id.cardView_additional)
        val additionalNameTv : TextView = itemView.findViewById(R.id.textviewsName_additional)
        val additionalMinTv : TextView = itemView.findViewById(R.id.textviewMin_additional)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdditionalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_additional_exercise , parent , false)
        return AdditionalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return additionalList.size
    }

    override fun onBindViewHolder(holder: AdditionalViewHolder, position: Int) {
        val category = additionalList[position]
        holder.addtionalImageView.setImageResource(category.additionalImage)
        holder.addtionalImageViewBack.setBackgroundResource(category.additionalImageBack)
        holder.additionalNameTv.text = category.additionalName
        holder.additionalMinTv.text = category.additionalMin
    }
}