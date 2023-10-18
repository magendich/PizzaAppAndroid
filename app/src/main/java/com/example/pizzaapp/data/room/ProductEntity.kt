package com.example.pizzaapp.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pizzaapp.data.room.ProductEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ProductEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = COLUMN_TITLE)
    val title: String,

    @ColumnInfo(name = COLUMN_PRICE)
    val price: String,

    @ColumnInfo(name = COLUMN_IMG)
    val img: String,

    @ColumnInfo(name = COLUMN_DESCRIPTION)
    val description: String,

    @ColumnInfo(name = COLUMN_INGREDIENTS)
    val ingredients: List<String>

) {
    companion object {
        const val TABLE_NAME =  "Product"
        const val COLUMN_TITLE = "title"
        const val COLUMN_PRICE = "price"
        const val COLUMN_IMG = "img"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_INGREDIENTS = "ingridients"
    }
}
