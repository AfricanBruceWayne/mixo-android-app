package com.mixo.staggeredgridlayout

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.NetworkImageView
import com.mixo.R

class StaggeredProductCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var productImage: NetworkImageView = itemView.findViewById(R.id.product_image)
    var productName: TextView = itemView.findViewById(R.id.product_name)
    var productRecipe: TextView = itemView.findViewById(R.id.product_recipe)
    var productDescription: TextView = itemView.findViewById(R.id.product_description)

}