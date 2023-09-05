package com.example.pizzaapp.data.repository

import com.example.pizzaapp.data.ApiRequestService
import com.example.pizzaapp.domain.model.PizzaModel
import javax.inject.Inject

class PizzaRepository @Inject constructor(
    private val apiService: ApiRequestService
) {
    suspend fun getPizzas(): List<PizzaModel> {
        return apiService.getPizzas().map {
            it.toDomain()
        }
    }
}