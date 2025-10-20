package com.example.activitylifecycle

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.activitylifecycle.ui.theme.ActivityLifeCycleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          display()
        }
    }
    override fun onStart() {
        super.onStart()
        showToast("onStart() called")
    }

    override fun onResume() {
        super.onResume()
        showToast("onResume() called")
    }

    override fun onPause() {
        super.onPause()
        showToast("onPause() called")
    }

    override fun onStop() {
        super.onStop()
        showToast("onStop() called")
    }

    override fun onRestart() {
        super.onRestart()
        showToast("onRestart() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("onDestroy() called")
    }
    private fun showToast(message: String){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }
}

@Composable
fun display(){
    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Activity Life Cycle", color= Color.Red, fontSize = 20.sp)
    }
}

