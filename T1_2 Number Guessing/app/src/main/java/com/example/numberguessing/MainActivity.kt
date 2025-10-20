package com.example.numberguessing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuessNumber()
        }
    }
}
@Composable
fun GuessNumber() {
    var inpNum by remember { mutableStateOf("") }
    var randNum by remember { mutableStateOf(Random.nextInt(1, 11)) }
    var message by remember { mutableStateOf("") }
    val guess = inpNum.toIntOrNull() // returns null if input is not numeric

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = inpNum,
            onValueChange = { inpNum = it },
            label = { Text("Enter a number to Guess (1–10)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                message = when {
                    inpNum.isBlank() -> "Please enter something"
                    guess == null -> "❌ Invalid input — only numbers allowed"
                    guess !in 1..10 -> "Enter a number between 1–10"
                    guess < randNum -> "Your guess is low"
                    guess > randNum -> "Your guess is high"
                    else -> {
                        val correctMsg = "🎉 Correct! The number was $randNum"
                        randNum = Random.nextInt(1, 11)
                        inpNum = ""
                        correctMsg
                    }
                }
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Check")
        }

        Text(
            text = message,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
