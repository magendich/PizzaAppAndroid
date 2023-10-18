package com.example.pizzaapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
 abstract class ProductDao {

     @Insert
     abstract suspend fun insertProducts(products: List<ProductEntity>)


     @Query("SELECT * FROM ${ProductEntity.TABLE_NAME}")
     abstract fun getAllProducts(): Flow<List<ProductEntity>>
}