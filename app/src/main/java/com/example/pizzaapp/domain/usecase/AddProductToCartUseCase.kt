package com.example.pizzaapp.domain.usecase

import com.example.pizzaapp.domain.repository.ProductRepositoryImpl

class AddProductToCartUseCase(
    val productRepositoryImpl: ProductRepositoryImpl
) {
    operator fun invoke() {}
}