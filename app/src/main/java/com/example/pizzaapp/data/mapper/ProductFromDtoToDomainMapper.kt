package com.example.pizzaapp.data.mapper

import com.example.pizzaapp.data.model.ProductDto
import com.example.pizzaapp.domain.model.Product
import javax.inject.Inject

class ProductFromDtoToDomainMapper @Inject constructor() {
    operator fun invoke(productDto: ProductDto): Product {
        with(productDto) {
            return Product(
                title = title,
                price = price,
                img = img,
                description = description,
                ingredients = ingredients
            )
        }
    }
}