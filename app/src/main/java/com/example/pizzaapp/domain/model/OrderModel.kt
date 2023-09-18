package com.example.pizzaapp.domain.model

data class OrderModel(
    val pizza: Product,
    val user: User,
    val address: Address
)