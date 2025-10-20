package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel()
{
    var quantity : Int = 0
        private set
    var flavour : String = ""
        private set

    fun setQuantity(newQuantity : Int)
    {
        quantity = newQuantity
    }

    fun setFlavour(newFlavour : String)
    {
        flavour = newFlavour
    }

    fun resetOrder()
    {
        quantity = 0
        flavour = ""
    }
}