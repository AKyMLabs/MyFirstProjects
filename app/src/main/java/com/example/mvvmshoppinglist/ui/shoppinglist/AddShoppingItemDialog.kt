package com.example.mvvmshoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.data.db.entity.ShoppingItem

class AddShoppingItemDialog(context:Context,var addDialogListener: AddDialogListener) : AppCompatDialog(context) {
    //Inide of this class, we need to tell our shopping activity the result of the dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)
        val tvAdd = findViewById<TextView>(R.id.tvAdd)
        val tvCancel = findViewById<TextView>(R.id.tvCancel)
        val etName = findViewById<EditText>(R.id.etName)
        val etAmount = findViewById<EditText>(R.id.etAmount)

        tvAdd?.setOnClickListener {
            val name = etName?.text.toString()
            val amount = etAmount?.text.toString()

            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Please enter all information",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClick(item)
            dismiss()
        }

        tvCancel?.setOnClickListener {
            cancel()
        }
    }


}