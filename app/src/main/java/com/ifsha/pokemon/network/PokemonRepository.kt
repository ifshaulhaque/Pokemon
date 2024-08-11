package com.ifsha.pokemon.network

import com.ifsha.pokemon.list.model.PokemonResponse
import com.ifsha.pokemon.details.model.PokemonDetails
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokeApi: PokeApi) {
    suspend fun getPokemonList(): PokemonResponse {
        return pokeApi.getPokemonList()
    }

    suspend fun getPokemonDetails(id: Int): PokemonDetails {
        return pokeApi.getPokemonDetails(id)
    }
}