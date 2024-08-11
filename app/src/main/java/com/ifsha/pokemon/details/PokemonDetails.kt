package com.ifsha.pokemon.details

data class PokemonDetails(
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val weight: Int,
    val abilities: List<Ability>,
    val sprites: Sprites,
    val cries: Cries
)

data class Ability(val name: String?)
data class Sprites(val frontDefault: String, val frontShiny: String)
data class Cries(val latest: String, val legacy: String)
