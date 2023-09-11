package com.example.pizzaapp.data.repository

import com.example.pizzaapp.data.ApiRequestService
import com.example.pizzaapp.data.mapper.ProductFromDtoToDomain
import com.example.pizzaapp.domain.model.ProductModel
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiService: ApiRequestService,
    private val productFromDtoToDomain: ProductFromDtoToDomain
) {
    suspend fun getPizzas(): List<ProductModel> {
        return apiService.getPizzas().map {
            productFromDtoToDomain.invoke(it)
        }
    }
}