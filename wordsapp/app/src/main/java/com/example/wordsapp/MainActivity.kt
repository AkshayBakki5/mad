package com.example.wordsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wordsapp.ui.theme.WordsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                ShowCounter()
            }
        }
    }


@Composable
fun ShowCounter() {
    val counterViewModel: CounterViewModel = viewModel()

    val counter by counterViewModel.count.observeAsState(0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(text = "Counter: $counter", fontSize = 40.sp, color = Color.Red)
        Spacer(modifier = Modifier.height(45.dp))
        Button(onClick = {
            counterViewModel.increment()
        }) {
            Text(text = "Increment")
        }
    }
}