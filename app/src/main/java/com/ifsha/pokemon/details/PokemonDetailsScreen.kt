package com.ifsha.pokemon.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.ifsha.pokemon.PokemonViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PokemonDetailsScreen(
    pokemonId: Int,
    viewModel: PokemonViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchDetails(pokemonId)
    }

    val pokemon = viewModel.pokemonDetails.value

    pokemon?.let {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Pokémon Image
            GlideImage(
                model = pokemon.sprites.frontDefault,
                contentDescription = "${pokemon.name} image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )

            // Pokémon Name
            Text(
                text = pokemon.name.capitalize(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(8.dp)
            )

            // Pokémon Base Experience, Height, and Weight
            Text(
                text = "Base Experience: ${pokemon.baseExperience}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Height: ${pokemon.height / 10.0} m",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Weight: ${pokemon.weight / 10.0} kg",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(4.dp)
            )

            // Abilities
            Text(
                text = "Abilities:",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
            pokemon.abilities.forEach { ability ->
                ability.name?.let {
                    Text(
                        text = it.capitalize(),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                    )
                }
            }

            // Play Pokémon Cry Button
            PlayCryButton(url = pokemon.cries.latest)
            PlayCryButton(url = pokemon.cries.legacy)

        }
    }
}
