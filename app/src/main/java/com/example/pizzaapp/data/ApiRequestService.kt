package com.example.pizzaapp.data

import com.example.pizzaapp.data.mapper.ProductDto
import retrofit2.http.GET

interface ApiRequestService {
    @GET("pizzatest.php")
    suspend fun getPizzas(): List<ProductDto>
}