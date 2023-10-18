package com.example.pizzaapp.data.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MainDataBase {
        return Room.databaseBuilder(context,MainDataBase::class.java, "MainDataBase").build()
    }

    @Provides
    fun provideProductDao(dataBase: MainDataBase): ProductDao {
        return dataBase.productDao()
    }
}