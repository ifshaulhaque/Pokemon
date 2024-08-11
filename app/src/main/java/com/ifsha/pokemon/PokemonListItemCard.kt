package com.ifsha.pokemon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PokemonListItemCard(pokemon: PokemonResult, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("pokemon_details/${extractPokemonId(pokemon.url)}")
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = pokemon.name.capitalize(Locale.current),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

fun extractPokemonId(url: String): Int? {
    return url.substringBeforeLast("/").substringAfterLast("/").toIntOrNull()
}
