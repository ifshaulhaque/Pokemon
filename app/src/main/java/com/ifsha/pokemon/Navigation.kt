package com.ifsha.pokemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "/pokemonGrid") {
        composable(route = "/pokemonGrid") {
            PokemonGridScreen()
        }
    }
}