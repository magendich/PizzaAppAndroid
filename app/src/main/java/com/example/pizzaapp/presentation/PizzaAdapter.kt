package com.example.pizzaapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.databinding.PizzaCardLayoutBinding
import com.example.pizzaapp.domain.model.PizzaModel
import com.squareup.picasso.Picasso

class PizzaAdapter: ListAdapter <PizzaModel, PizzaAdapter.PizzaViewHolder>(PizzaDiffUtil()) {

    class PizzaViewHolder(private val pizzaUI: PizzaCardLayoutBinding): RecyclerView.ViewHolder(pizzaUI.root) {
        fun bind(pizzaModel: PizzaModel) {
            pizzaUI.apply {
                pizzaTitle.text = pizzaModel.title
                btnBuy.text = pizzaModel.price + "р."
                Picasso.get().load(pizzaModel.img).into(pizzaImage)
                pizzaDesc.text = pizzaModel.description
                pizzaIngredients.text = pizzaModel.ingredients.joinToString(", ")
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PizzaAdapter.PizzaViewHolder {
        return PizzaViewHolder(pizzaUI = PizzaCardLayoutBinding
            .inflate(LayoutInflater.from(parent.context),
                parent, false))
    }

    override fun onBindViewHolder(holder: PizzaAdapter.PizzaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PizzaDiffUtil: DiffUtil.ItemCallback<PizzaModel>() {
        override fun areItemsTheSame(oldItem: PizzaModel, newItem: PizzaModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: PizzaModel, newItem: PizzaModel): Boolean {
            return oldItem == newItem
        }

    }
}