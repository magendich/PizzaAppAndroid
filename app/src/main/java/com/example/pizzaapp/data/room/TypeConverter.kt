package com.example.pizzaapp.data.room

import androidx.room.TypeConverter

class TypeConverter {

    @TypeConverter
    fun fromStringToList(value: String): List<String> {
        return value.split(",").map { it.trim() }
    }

    @TypeConverter
    fun fromListToString(list: List<String>): String {
        return list.joinToString(",")
    }
}