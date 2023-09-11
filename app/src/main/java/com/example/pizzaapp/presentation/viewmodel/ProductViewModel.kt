package com.example.pizzaapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzaapp.data.repository.ProductRepository
import com.example.pizzaapp.domain.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
): ViewModel() {

    private val mutablePizzas = MutableLiveData<List<ProductModel>>()
    val observablePizzas: LiveData<List<ProductModel>> = mutablePizzas

    fun fetchPizzas() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                val pizzas = productRepository.getPizzas()
                mutablePizzas.postValue(pizzas)
            }
        }
    }
}