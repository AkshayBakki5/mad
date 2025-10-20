package com.example.task7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowCounter()
        }
    }
}

@Composable
fun ShowCounter(counterViewModel: CounterViewModel = viewModel()) {
    val counter by counterViewModel::count

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(text = "Counter: $counter", fontSize = 40.sp, color = Color.Red)
        Spacer(modifier = Modifier.height(45.dp))
        Button(onClick = { counterViewModel.increment() }) {
            Text(text = "Increment")
        }
    }
}

