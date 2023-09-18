package com.example.pizzaapp.data.repository

import com.example.pizzaapp.data.ApiRequestService
import com.example.pizzaapp.data.mapper.ProductFromDtoToDomainMapper
import com.example.pizzaapp.domain.model.Product
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiService: ApiRequestService,
    private val productFromDtoToDomainMapper: ProductFromDtoToDomainMapper
) {
    suspend fun getPizzas(): List<Product> {
        return apiService.getPizzas().map {
            productFromDtoToDomainMapper(it)
        }
    }
}