package com.example.utslabmdhafin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MealPlansAdapter(private val mealplansList : ArrayList<MealPlans>) :
    RecyclerView.Adapter<MealPlansAdapter.MealPlansViewHolder>() {

    class MealPlansViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
        val MealPlansImageView : ImageView = itemView.findViewById(R.id.imageView_mealPlans)
        val MealPlansNameTv : TextView = itemView.findViewById(R.id.textView_mealPlans)
        val MealPlansKcalTv : TextView = itemView.findViewById(R.id.textviewkcal_mealPlans)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealPlansViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_meal_plans , parent , false)
        return MealPlansViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mealplansList.size
    }

    override fun onBindViewHolder(holder: MealPlansViewHolder, position: Int) {
        val category = mealplansList[position]
        holder.MealPlansImageView.setImageResource(category.MealPlansImage)
        holder.MealPlansNameTv.text = category.MealPlansName
        holder.MealPlansKcalTv.text = category.MealPlansKcal
    }
}