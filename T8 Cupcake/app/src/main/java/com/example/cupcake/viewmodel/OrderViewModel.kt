package com.example.cupcake.viewmodel


import android.icu.util.Calendar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Locale

class OrderViewModel : ViewModel()
{
    var quantity : Int = 0
        private set
    var flavour : String = ""
        private set

    var date: String = ""
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
        date = ""
    }

    fun setDate(newDate: String)
    {
        date = newDate
    }
    fun getPickupOptions(): List<String>
    {
        var options = mutableListOf<String>()
        var calendar = Calendar.getInstance()

        var formatted = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(calendar.time)
        options.add(formatted)
        calendar.add(Calendar.DATE , 1)

        repeat(4)
        {
            var formatted = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(calendar.time)
            options.add(formatted)
            calendar.add(Calendar.DATE , 1)
        }
        return options
    }

    fun getOrderSummary():String = "Order Summary-\n"+
            "Quantity:$quantity\n"+
            "Flavour:$flavour\n"+
            "Pickup Date:$date"

}


