package com.example.pizzaapp.domain.usecase

import com.example.pizzaapp.domain.repository.ProductRepository

class AddProductToCartUseCase(
    val productRepository: ProductRepository
) {
    operator fun invoke() {}
}