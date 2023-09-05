package com.example.pizzaapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzaapp.data.repository.PizzaRepository
import com.example.pizzaapp.domain.model.PizzaModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor(
    private val pizzaRepository: PizzaRepository
): ViewModel() {

    private val mutablePizzas = MutableLiveData<List<PizzaModel>>()
    val observablePizzas: LiveData<List<PizzaModel>> = mutablePizzas

    fun fetchPizzas() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                val pizzas = pizzaRepository.getPizzas()
                mutablePizzas.postValue(pizzas)
            }
        }
    }
}