package com.example.mvvmshoppinglist.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_amount")
    var amount: Int
) {
    //Set the auto Generate so that Room will handle the primary key id
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}