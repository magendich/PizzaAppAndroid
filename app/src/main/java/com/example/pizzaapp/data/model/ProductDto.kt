package com.example.pizzaapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductDto(
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
): Serializable
