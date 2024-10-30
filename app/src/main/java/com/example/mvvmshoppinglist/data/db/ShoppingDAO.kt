package com.example.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmshoppinglist.data.db.entity.ShoppingItem

@Dao
interface ShoppingDAO {

    //in SQL it doesn't allow to write in the database in the main thread
    //so we have to call these asynchronously, to do that we will use "suspend"

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsort(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}