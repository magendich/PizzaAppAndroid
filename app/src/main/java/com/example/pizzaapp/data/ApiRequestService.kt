package com.example.pizzaapp.data

import com.example.pizzaapp.data.mapper.PizzaDto
import retrofit2.http.GET

interface ApiRequestService {
    @GET("pizzatest.php")
    suspend fun getPizzas(): List<PizzaDto>
}