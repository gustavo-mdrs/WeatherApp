package com.weatherapp.ui.theme.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.weatherapp.MainViewModel
import com.weatherapp.ui.theme.HomePage
import com.weatherapp.ui.theme.ListPage
import com.weatherapp.ui.theme.MapPage

@Composable
fun MainNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(navController, startDestination = Route.Home) {
        composable<Route.Home> { HomePage(viewModel = viewModel) }
        composable<Route.List> { ListPage(viewModel = viewModel) }
        composable<Route.Map> { MapPage(viewModel = viewModel) }
    }
}