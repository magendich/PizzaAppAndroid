package com.example.pizzaapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database (
    entities = [ProductEntity::class],
    version = 2
)
@TypeConverters(TypeConverter::class)
abstract class MainDataBase: RoomDatabase() {
    abstract fun productDao(): ProductDao
}