package com.example.mvvmshoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmshoppinglist.data.db.entity.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDAO

    //Create an instance of the shopping database inside of this class > SINGLETON
    //WE NEED TO MAKE SURE THERE'S ONLY ONE INSTANCE AT A TIME
    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        //Create an operator function where everytime ShoppingDatabase() is called, it will go through this code
        //The "?:" is a null checker where it will read the code to the right if it isn't null
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        //method used to instanciate our database
        private fun createDatabase(context: Context): ShoppingDatabase {
            return Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDB.db").build()
        }
    }
}