package com.example.pizzaapp.data.mapper

import com.example.pizzaapp.data.model.ProductDto
import com.example.pizzaapp.domain.model.ProductModel
import javax.inject.Inject

class ProductFromDtoToDomainMapper @Inject constructor() {
    operator fun invoke(productDto: ProductDto): ProductModel {
        with(productDto) {
            return ProductModel(
                title = title,
                price = price,
                img = img,
                description = description,
                ingredients = ingredients
            )
        }
    }
}