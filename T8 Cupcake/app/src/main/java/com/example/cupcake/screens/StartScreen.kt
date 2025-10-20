package com.example.cupcake.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue

@Composable
fun StartScreen(onNext:(Int)-> Unit)
{
    var quantity by remember { mutableStateOf(1) }

    Column(Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
    {
        Text("Choose Quantity", fontSize = 20.sp, color = Color.DarkGray)
        Spacer(Modifier.height(25.dp))
        Row(verticalAlignment = Alignment.CenterVertically)
        {
            Button(onClick = { if (quantity > 1)
                quantity-- },
                Modifier.size(50.dp))
            {
                Text("-")
            }

            Spacer(Modifier.width(25.dp))
            Text(quantity.toString())
            Spacer(Modifier.width(25.dp))

            Button(onClick = {quantity++ },
                Modifier.size(50.dp))
            {
                Text("+")
            }
        }
        Spacer(Modifier.height(25.dp))
        Button(onClick = {onNext(quantity)})
        {
            Text("Next")
        }
    }

}
