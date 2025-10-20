package com.example.cupcake.screens


import android.content.Context
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import com.example.cupcake.viewmodel.OrderViewModel
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
@Composable
fun SummaryScreen(onCancel:() -> Unit,
                  viewModel: OrderViewModel)
{
    var summary = viewModel.getOrderSummary()
    var context = LocalContext.current

    Column(Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(summary )
        Spacer(Modifier.height(20.dp))
        Button(onClick = {
            shareOrder(context, summary)
        })
        {
            Text("Send Order")
        }
        Spacer(Modifier.height(19.dp))
        Button(onClick = onCancel)
        {
            Text("Cancel Order")
        }

    }
}

fun shareOrder(context: Context, summary: String)
{
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, summary)
    }

    context.startActivity(Intent.createChooser(intent , "Share Order Details"))
}

