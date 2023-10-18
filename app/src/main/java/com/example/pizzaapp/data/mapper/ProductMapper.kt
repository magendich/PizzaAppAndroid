package com.example.pizzaapp.data.mapper

import com.example.pizzaapp.data.model.ProductDto
import com.example.pizzaapp.data.room.ProductEntity
import com.example.pizzaapp.domain.model.Product
import javax.inject.Inject

class ProductMapper @Inject constructor() {

    fun mapProductDtoToProductEntity(productDto: ProductDto): ProductEntity {
        with(productDto) {
            return ProductEntity(
                id = 0,
                title = title,
                price = price,
                img = img,
                description = description,
                ingredients = ingredients
            )
        }
    }

    fun mapProductEntityToProduct(productEntity: ProductEntity): Product {
        with(productEntity) {
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