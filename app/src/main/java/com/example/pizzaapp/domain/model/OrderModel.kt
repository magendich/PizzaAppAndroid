package com.example.pizzaapp.domain.model

data class OrderModel(
    val pizza: ProductModel,
    val user: UserModel,
    val address: AddressModel
)