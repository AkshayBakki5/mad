package com.example.cupcake.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cupcake.screens.FlavourScreen
import com.example.cupcake.screens.PickupScreen
import com.example.cupcake.screens.StartScreen
import com.example.cupcake.screens.SummaryScreen
import com.example.cupcake.viewmodel.OrderViewModel

enum class CupcakeScreen {Start , Flavour ,Pickup , Summary }
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
            FlavourScreen(onNext = {
                navController.navigate(CupcakeScreen.Pickup.name)
            }, onCancel = {
                viewModel.resetOrder()
                navController.popBackStack(CupcakeScreen.Start.name , inclusive = false)
            }, viewModel = viewModel)
        }

        composable(CupcakeScreen.Pickup.name)
        {
            PickupScreen(onNext = {
                navController.navigate(CupcakeScreen.Summary.name)} ,
                onCancel = {
                    viewModel.resetOrder()
                    navController.popBackStack(CupcakeScreen.Start.name , inclusive = false) },
                viewModel = viewModel)
        }

        composable(CupcakeScreen.Summary.name)
        {
            SummaryScreen(onCancel = {
                viewModel.resetOrder()
                navController.popBackStack(CupcakeScreen.Start.name, inclusive = false)
            }, viewModel = viewModel)
        }

    }
}

