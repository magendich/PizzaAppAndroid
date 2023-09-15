package com.example.pizzaapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.databinding.ItemCardLayoutBinding
import com.example.pizzaapp.domain.model.ProductModel
import com.squareup.picasso.Picasso

class ProductAdapter: ListAdapter <ProductModel, ProductAdapter.PizzaViewHolder>(PizzaDiffUtil()) {

    class PizzaViewHolder(private val pizzaUI: ItemCardLayoutBinding): RecyclerView.ViewHolder(pizzaUI.root) {
        fun bind(productModel: ProductModel) {
            pizzaUI.apply {
                pizzaTitle.text = productModel.title
                btnBuy.text = productModel.price + " р."
                Picasso.get().load(productModel.img).into(pizzaImage)
                pizzaDesc.text = productModel.description
                pizzaIngredients.text = productModel.ingredients.joinToString(", ")
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PizzaViewHolder {
        return PizzaViewHolder(pizzaUI = ItemCardLayoutBinding
            .inflate(LayoutInflater.from(parent.context),
                parent, false))
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PizzaDiffUtil: DiffUtil.ItemCallback<ProductModel>() {
        override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem == newItem
        }

    }
}