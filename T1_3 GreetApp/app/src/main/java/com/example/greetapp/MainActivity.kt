package com.example.greetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetapp.ui.theme.GreetAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetApp()
        }
    }
}

@Composable
fun GreetApp() {
    var name by remember { mutableStateOf("") }
    var custMsg by remember { mutableStateOf("") }
    var outPut by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Greeting Function", fontSize = 20.sp)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        OutlinedTextField(
            value = custMsg,
            onValueChange = { custMsg = it }, // ✅ Fixed (was 'name=it' before)
            label = { Text("Enter Custom Message") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        Button(
            onClick = {
                outPut = greet(name, if (custMsg.isBlank()) null else custMsg)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Greet")
        }

        Text(outPut, fontSize = 18.sp, modifier = Modifier.padding(top = 16.dp))
    }
}

fun greet(name: String, message: String? = null): String {
    return "${message ?: "Hello"}, $name!"
}

@Preview(showBackground = true)
@Composable
fun PreviewGreetApp() {
    GreetApp()
}
