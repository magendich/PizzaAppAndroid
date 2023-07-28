package com.example.pizzaapp.domain.model

data class OrderModel(
    val pizza: PizzaModel,
    val user: UserModel,
    val address: AddressModel
)