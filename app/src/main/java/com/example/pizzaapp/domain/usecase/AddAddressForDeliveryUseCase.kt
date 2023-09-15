package com.example.pizzaapp.domain.usecase

import com.example.pizzaapp.domain.repository.AddressRepositoryImpl

class AddAddressForDeliveryUseCase(
    val addressRepositoryImpl: AddressRepositoryImpl
) {
    operator fun invoke() {
    }
}