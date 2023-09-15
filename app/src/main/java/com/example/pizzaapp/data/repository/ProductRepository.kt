package com.example.pizzaapp.data.repository

import com.example.pizzaapp.data.ApiRequestService
import com.example.pizzaapp.data.mapper.ProductFromDtoToDomainMapper
import com.example.pizzaapp.domain.model.ProductModel
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiService: ApiRequestService,
    private val productFromDtoToDomainMapper: ProductFromDtoToDomainMapper
) {
    suspend fun getPizzas(): List<ProductModel> {
        return apiService.getPizzas().map {
            productFromDtoToDomainMapper(it)
        }
    }
}