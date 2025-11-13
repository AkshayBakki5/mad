package com.example.usersrecord

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.usersrecord.ui.theme.UsersRecordTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Pass context to get the database instance
            val context = applicationContext
            val database = UserDatabase.getInstance(context)
            InsertRecord(database)
        }
    }
}

@Composable
fun InsertRecord(database: UserDatabase) {
    var name: String by remember { mutableStateOf("") }
    var phoneNum: String by remember { mutableStateOf("") }
    val context: Context = LocalContext.current
    val userdao: UserDAO = database.userDAO()
    val scope: CoroutineScope = rememberCoroutineScope()

    Column(Modifier.fillMaxSize().wrapContentSize(Alignment.Center).padding(16.dp)) {
        Text("Enter details", fontSize = 20.sp, color = Color.Red)

        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = phoneNum,
            onValueChange = { phoneNum = it },
            label = { Text("Enter Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(20.dp))
        Button(onClick = {
            if(name.isNotBlank() && phoneNum.isNotBlank()) {
                scope.launch {
                    userdao.insert(User(userName = name, userPhone = phoneNum))
                    Toast.makeText(context, "Successfully inserted", Toast.LENGTH_LONG).show()
                    name = ""
                    phoneNum = ""
                }
            } else {
                Toast.makeText(context, "Please enter valid name and phone number", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Insert Row")
        }

    }
}
