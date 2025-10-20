package com.example.loginpage

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpage.ui.theme.LoginPageTheme
import com.example.loginpage.SecondActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          LoginPage()
        }
    }
}

@Composable
fun LoginPage(){
    var userName by remember { mutableStateOf("") }
    var pswd by remember { mutableStateOf("") }
    val context= LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(10.dp).background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(R.drawable.cvr_logo),
            contentDescription = "CVR Logo",
            modifier = Modifier.size(300.dp)
        )
        Spacer(modifier = Modifier.height(26.dp))
        OutlinedTextField(
            value = userName,
            onValueChange = {userName=it},
            label = {Text("Enter UserName")}
        )
        Spacer(modifier = Modifier.height(26.dp))
        OutlinedTextField(
            value = pswd,
            onValueChange = {pswd=it},
            label = {Text("Enter Password")},
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(26.dp))
        Button(onClick = {
            if (userName=="akshay" && pswd=="123"){
                val intent= Intent(context, SecondActivity::class.java)
                intent.putExtra("userName",userName)
                context.startActivity(intent)
            }
            else{
                Toast.makeText(context,"Invalid Credntials", Toast.LENGTH_LONG).show()
            }

        }) {Text("Login") }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginPage()
}