package com.example.cupcake.screens


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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cupcake.viewmodel.OrderViewModel
import org.w3c.dom.Text

@Composable
fun FlavourScreen(onNext:()-> Unit , onCancel:()-> Unit , viewModel: OrderViewModel)
{
    var flavours = listOf("Vennila", "Dark Chocolate", "Butter Scotch","Red Velvet")
    Column(Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text("Choose Flavour", fontSize = 25.sp, color = Color.Black)
        Spacer(Modifier.height(25.dp))
        flavours.forEach() { flavour->
            Button(onClick =
                {
                    viewModel.setFlavour(flavour)
                    onNext()},
                Modifier.fillMaxWidth().padding(vertical = 4.dp))
            {
                Text(flavour)
            }
        }
        Spacer(Modifier.height(19.dp))
        OutlinedButton(onClick = onCancel)
        {
            Text("Cancel Order")
        }
    }
}

