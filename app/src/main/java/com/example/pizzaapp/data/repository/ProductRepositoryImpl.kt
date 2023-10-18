package com.example.pizzaapp.data.repository

import com.example.pizzaapp.data.ApiRequestService
import com.example.pizzaapp.data.mapper.ProductMapper
import com.example.pizzaapp.data.room.ProductDao
import com.example.pizzaapp.domain.model.Product
import com.example.pizzaapp.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiRequestService,
    private val productMapper: ProductMapper,
    private val productDao: ProductDao
): ProductRepository {

    override suspend fun fetchPizzas() {
        val pizzasForDb = apiService.getPizzas().map {
            productMapper.mapProductDtoToProductEntity(it)
        }
        productDao.insertProducts(pizzasForDb)
    }

    override suspend fun getPizzas(): Flow<List<Product>> {
        return productDao.getAllProducts().map { productEntityList ->
            productEntityList.map {
                productMapper.mapProductEntityToProduct(it)
            }

        }
    }
}