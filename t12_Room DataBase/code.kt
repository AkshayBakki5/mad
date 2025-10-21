in chrome search the dependency roomdatabse dependency in jetpack and paste this
val room_version = "2.8.2"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:${room_version}")

create a class User.kt in com.example.myapplication
create a database UserDao.kt
create a data class UserDatabase.kt

MainActivity.kt
package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.TableInfo
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val database = UserDatabase.getInstance(this)
            InsertRecord(database)
        }
    }
}
@Composable
fun InsertRecord(database: UserDatabase)
{
    var name by remember { mutableStateOf("") }
    var phonenum by remember { mutableStateOf("") }
    var context = LocalContext.current
    val userdao = database.userDAO()
    val scope = rememberCoroutineScope()
    Column (Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
    {
        Text("Enter Your Details", fontSize = 20.sp, color = Color.Black)
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(value = name,
            onValueChange = {name = it},
            label = {Text("Enter Name:")},
            modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(value = phonenum ,
            onValueChange = {phonenum = it},
            label = {Text("Enter PhoneNumber:")},
            modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(20.dp))
        Button(onClick = {
            scope.launch {
                userdao.insert(User(userName = name, userPhone = phonenum))
                Toast.makeText(context,"Successfully inserted", Toast.LENGTH_SHORT).show()
            }
            })
        {
            Text("Insert Row:")
        }
    }
}


User.kt
package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CSEG")
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid : Int = 0,
    val userName: String,
    val userPhone: String)



UserDao.kt
package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)
}


UserDatabase.kt
package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
@Database(entities = [User::class] , version = 1)
abstract class UserDatabase : RoomDatabase()
    {
        abstract fun userDAO() : UserDao
        companion object
        {
            private var INSTANCE : UserDatabase? = null
            fun getInstance(context: Context): UserDatabase
            {
                return INSTANCE ?: synchronized(this)
                {
                    val instance = Room.databaseBuilder(context.applicationContext,
                        UserDatabase::class.java,
                        "Vidu_db").build()
                    INSTANCE = instance
                    instance
                }
            }
        }
    }
