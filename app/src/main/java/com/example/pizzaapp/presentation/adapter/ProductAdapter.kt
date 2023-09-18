package com.example.pizzaapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.databinding.ItemCardLayoutBinding
import com.example.pizzaapp.domain.model.Product
import com.squareup.picasso.Picasso

class ProductAdapter: ListAdapter <Product, ProductAdapter.PizzaViewHolder>(PizzaDiffUtil()) {

    class PizzaViewHolder(private val pizzaUI: ItemCardLayoutBinding): RecyclerView.ViewHolder(pizzaUI.root) {
        fun bind(product: Product) {
            pizzaUI.apply {
                pizzaTitle.text = product.title
                btnBuy.text = product.price + " р."
                Picasso.get().load(product.img).into(pizzaImage)
                pizzaDesc.text = product.description
                pizzaIngredients.text = product.ingredients.joinToString(", ")
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

    class PizzaDiffUtil: DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }
}