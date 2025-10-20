package com.example.settersandgetters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.settersandgetters.ui.theme.SettersAndGettersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SettersAndGettersTheme {
                CompanionObjectDemoApp()
            }
        }
    }
}

// ----------------------------
// User class with companion object, getters, and setters
// ----------------------------
class User {
    companion object {
        var instanceCount = 0
            private set
    }

    var name: String = "Guest"

    var age: Int = 18
        set(value) {
            field = if (value < 0) 0 else value
        }

    init {
        instanceCount++
    }
}

// ----------------------------
// Composable UI to show the User data
// ----------------------------
@Composable
fun CompanionObjectDemoApp() {
    // Create a user instance
    var user by remember { mutableStateOf(User()) }

    // Track the number of instances
    var count by remember { mutableStateOf(User.instanceCount) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Name: ${user.name}")
        Text(text = "Age: ${user.age}")
        Text(text = "User Instances: $count")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            // Update user data
            user.name = "Akshay"
            user.age = 19

            // Create another instance to see instance count increase
            val newUser = User()
            user = newUser
            count = User.instanceCount
        }) {
            Text("Update User")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SettersAndGettersTheme {
        CompanionObjectDemoApp()
    }
}



