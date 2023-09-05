package com.example.pizzaapp.domain.model

data class PizzaModel(
    val title: String,
    val price: String,
    val img: String,
    val description: String,
    val ingredients: List<String>

)
