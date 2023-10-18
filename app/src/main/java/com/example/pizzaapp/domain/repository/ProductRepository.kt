package com.example.pizzaapp.domain.repository

import com.example.pizzaapp.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun fetchPizzas()
    suspend fun getPizzas(): Flow<List<Product>>
}