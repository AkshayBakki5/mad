package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipCalculator()

        }
    }
}

@Composable
fun TipCalculator()
{
    var billAmount by remember { mutableStateOf("") }
    var tipPercent by remember { mutableStateOf("") }
    var tipAmount by remember { mutableStateOf<Double?>(null) }
    var totalAmount by remember { mutableStateOf<Double?>(null) }
    var errorMessage by remember { mutableStateOf <String?>(null) }

    Column (
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text("Tip Calculator")
        OutlinedTextField(
            value = billAmount,
            onValueChange = {billAmount = it},
            label = {Text("Bill Amount")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Spacer(modifier = Modifier.padding(30.dp))
        OutlinedTextField(
            value = tipPercent,
            onValueChange = {tipPercent = it},
            label = {Text("Tip Percent")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Button(
            onClick = {
                val bill = billAmount.toDoubleOrNull()
                val tip = tipPercent.toDoubleOrNull()
                if(bill != null && tip != null && bill >= 0 && tip >= 0)
                {
                    tipAmount = bill*(tip/100)
                    totalAmount = bill + tipAmount!!
                    errorMessage = null
                }
                else
                {
                    tipAmount = null
                    totalAmount = null
                    errorMessage = "Please Enter valid, non - negative Numbers."
                }
            }
        )
        { Text("Calculate")}

        Spacer(modifier = Modifier.height(50.dp))

        errorMessage?. let {
            Text(text =it, color = Color.Red)
        }
        tipAmount?. let {
            Text("Tip:$${"%.2f".format(it)}", color = Color.Blue)
        }

        totalAmount ?. let {
            Text("Total Amount:$${"%.2f".format(it)}", color = Color.Blue)
        }

    }
}
