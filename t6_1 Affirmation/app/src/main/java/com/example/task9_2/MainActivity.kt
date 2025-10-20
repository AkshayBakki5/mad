package com.example.task9_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.task9_2.ui.theme.Task92Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                affirmation()
            }
        }

}

data class Affirmation(var image: Int, var text: String)

@Composable
fun affirmation() {
    val affImages = listOf(
        Affirmation(R.drawable.car, "Car"),
        Affirmation(R.drawable.cvrlogo, "CVR"),
        Affirmation(R.drawable.movie, "Pushpa"),
        Affirmation(R.drawable.nature, "Nature"),
        Affirmation(R.drawable.tanjiro,"Tanjiro"),
        Affirmation(R.drawable.virat,"Virat"),
        Affirmation(R.drawable.prabhas,"Salaar")
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        items(affImages) {
            affirmation ->affirmationLayout(affirmation)
        }
    }
}

@Composable
fun affirmationLayout(affirmation: Affirmation) {
    Card {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = affirmation.image),
                contentDescription = null
            )
            Text(text = affirmation.text, modifier = Modifier.padding(top = 8.dp))
        }
    }
}

