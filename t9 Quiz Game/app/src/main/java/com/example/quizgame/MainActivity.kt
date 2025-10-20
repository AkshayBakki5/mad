package com.example.quizgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizgame.data.Question
import com.example.quizgame.ui.theme.QuizGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enable full-screen layout
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "title") {
                composable("title") {
                    TitleScreen(navController)
                }
                composable("homescreen") {
                    GameScreen(navController)
                }
            }
        }
    }
}

@Composable
fun TitleScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome To Quiz Game", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Button(onClick = { navController.navigate("homescreen") }) {
            Text("Start Quiz Game")
        }
    }
}

@Composable
fun GameScreen(navController: NavController) {
    val question = remember {
        Question(
            text = "Which language supports Android?",
            options = listOf("Java", "Kotlin", "Python", "C++"),
            answer = "Kotlin"
        )
    }

    var selectedOption by remember { mutableStateOf<String?>(null) }
    var showResult by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
        Text(question.text, fontSize = 20.sp, color = Color.Red)
        Spacer(Modifier.height(16.dp))

        question.options.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = {
                        selectedOption = option
                        showResult = true
                    },
                    modifier = Modifier.padding(10.dp)
                )
                Text(option)
            }
        }

        Spacer(Modifier.height(16.dp))

        if (showResult) {
            Text(
                text = if (selectedOption == question.answer) "Correct!" else "Wrong",
                color = if (selectedOption == question.answer) Color.Green else Color.Red,
                fontSize = 18.sp
            )
        }
    }
}
