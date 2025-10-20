package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.screens.FlavourScreen
import com.example.myapplication.screens.StartScreen
import com.example.myapplication.viewmodel.OrderViewModel

enum class CupcakeScreen {Start , Flavour }
@Composable
fun CupcakeNavHost(navController: NavHostController, viewModel: OrderViewModel)
{
    NavHost(navController , startDestination = CupcakeScreen.Start.name)
    {
        composable(CupcakeScreen.Start.name)
        {
            StartScreen(onNext = {
                    qty -> viewModel.setQuantity(qty)
                navController.navigate(CupcakeScreen.Flavour.name)
            })

        }
        composable (CupcakeScreen.Flavour.name)
        {
            FlavourScreen(onFlavourSelected = {
                // Flavour selection is the final step, so no navigation needed here.
            }, onCancel = {
                viewModel.resetOrder()
                navController.popBackStack(CupcakeScreen.Start.name , inclusive = false)
            }, viewModel = viewModel)
        }
    }
}