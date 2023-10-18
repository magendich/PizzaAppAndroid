package com.example.pizzaapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzaapp.data.repository.ProductRepositoryImpl
import com.example.pizzaapp.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepositoryImpl
): ViewModel() {

    private val mutablePizzas = MutableLiveData<List<Product>>()
    val observablePizzas: LiveData<List<Product>> = mutablePizzas

    fun fetchProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.fetchPizzas()
        }
    }

    fun observeProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.getPizzas().collect() {
                mutablePizzas.postValue(it)
            }
        }
    }

//    fun fetchPizzas() {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//
//                val pizzas = productRepository.getPizzas()
//                mutablePizzas.postValue(pizzas)
//            }
//        }
//    }
}