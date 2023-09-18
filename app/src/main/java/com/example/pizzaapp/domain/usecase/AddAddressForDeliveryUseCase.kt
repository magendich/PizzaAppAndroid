package com.example.pizzaapp.domain.usecase

import com.example.pizzaapp.domain.repository.AddressRepository

class AddAddressForDeliveryUseCase(
    val addressRepository: AddressRepository
) {
    operator fun invoke() {
    }
}