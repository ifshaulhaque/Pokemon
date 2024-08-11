package com.ifsha.pokemon.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.ifsha.pokemon.list.PokemonViewModel

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
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Pokémon Image in a Circular Container
            GlideImage(
                model = pokemon.sprites?.frontDefault,
                contentDescription = "${pokemon.name} image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .shadow(
                        elevation = 8.dp,
                        shape = CircleShape
                    )
                    .background(Color.White)
                    .size(150.dp)
                    .padding(8.dp)
                    .clip(CircleShape)
            )

            // Pokémon Name
            pokemon.name?.let { it1 ->
                Text(
                    text = it1.capitalize(),
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

            // Pokémon Base Experience, Height, and Weight with Icons
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                InfoWithIcon(label = "Base Exp", value = "${pokemon.baseExperience}", icon = Icons.Default.Star)
                InfoWithIcon(label = "Height", value = "${pokemon.height?.div(10.0)} m", icon = Icons.Default.Star)
                InfoWithIcon(label = "Weight", value = "${pokemon.weight?.div(10.0)} kg", icon = Icons.Default.Star)
            }

            // Abilities Section
            Spacer(modifier = Modifier.height(24.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Abilities",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    pokemon.abilities.forEach { ability ->
                        ability.ability?.name?.let {
                            Text(
                                text = it.capitalize(),
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
                            )
                        }
                    }
                }
            }

            // Play Pokémon Cry Buttons
            Spacer(modifier = Modifier.height(16.dp))
            pokemon.cries?.let {
                it.latest?.let { latestCry ->
                    PlayCryButton(url = latestCry)
                }
                it.legacy?.let { legacyCry ->
                    PlayCryButton(url = legacyCry)
                }
            }
        }
    }
}

@Composable
fun InfoWithIcon(label: String, value: String, icon: ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
