package com.example.pizzaapp.data.mapper

import com.example.pizzaapp.domain.model.PizzaModel
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PizzaDto(

    @SerializedName("title")
    val title: String,

    @SerializedName("price")
    val price: String,

    @SerializedName("img")
    val img: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("ingridients")
    val ingredients: List<String>

): Serializable {
    fun toDomain(): PizzaModel {
        return PizzaModel(
            title = title,
            price = price,
            img = img,
            description = description,
            ingredients = ingredients
        )
    }
}