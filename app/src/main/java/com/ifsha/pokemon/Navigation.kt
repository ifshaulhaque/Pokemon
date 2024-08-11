package com.ifsha.pokemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ifsha.pokemon.details.PokemonDetailsScreen
import com.ifsha.pokemon.list.PokemonGridScreen

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "/pokemonGrid") {
        composable(route = "/pokemonGrid") {
            PokemonGridScreen(navHostController)
        }

        composable("pokemon_details/{pokemonId}") { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("pokemonId")?.toIntOrNull()
            if (pokemonId != null) {
                PokemonDetailsScreen(pokemonId = pokemonId)
            }
        }
    }
}