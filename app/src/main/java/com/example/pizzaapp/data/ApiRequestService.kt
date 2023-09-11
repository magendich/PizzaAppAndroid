package com.example.pizzaapp.data

import com.example.pizzaapp.data.model.ProductDto
import retrofit2.http.GET

interface ApiRequestService {
    @GET("pizzatest.php")
    suspend fun getPizzas(): List<ProductDto>
}