package com.example.cupcake.screens


import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cupcake.viewmodel.OrderViewModel

@Composable
fun PickupScreen(onNext:() -> Unit, onCancel:() -> Unit , viewModel: OrderViewModel)
{
    var options = viewModel.getPickupOptions()

    Column(Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text("Choose PickUp Date:")
        Spacer(Modifier.height(19.dp))
        options.forEach {date ->
            Button(onClick = {
                viewModel.setDate(date)
                onNext()
            }, Modifier.fillMaxWidth().padding(vertical = 4.dp))
            {
                Text(date)
            }
        }
        Spacer(Modifier.height(20.dp))
        OutlinedButton(onClick = onCancel)
        {
            Text("Cancel Order")
        }

    }
}
