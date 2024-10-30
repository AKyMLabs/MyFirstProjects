package com.example.mvvmshoppinglist.ui.shoppinglist

import com.example.mvvmshoppinglist.data.db.entity.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClick(item: ShoppingItem)
}