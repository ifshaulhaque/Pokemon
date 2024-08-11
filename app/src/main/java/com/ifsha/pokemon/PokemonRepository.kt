package com.ifsha.pokemon

import com.ifsha.pokemon.details.PokemonDetails
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokeApi: PokeApi) {
    suspend fun getPokemonList(): PokemonResponse {
        return pokeApi.getPokemonList()
    }

    suspend fun getPokemonDetails(id: Int): PokemonDetails {
        return pokeApi.getPokemonDetails(id)
    }
}