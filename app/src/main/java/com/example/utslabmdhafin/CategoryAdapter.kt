package com.example.utslabmdhafin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CategoryAdapter(private val categoryList : ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
        val categoryImageView : ImageView = itemView.findViewById(R.id.imageView_category)
        val categoryNameTv : TextView = itemView.findViewById(R.id.textView_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_category , parent , false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.categoryImageView.setImageResource(category.categoryImage)
        holder.categoryNameTv.text = category.categoryName
    }
}