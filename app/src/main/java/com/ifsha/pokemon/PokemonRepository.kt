package com.ifsha.pokemon

import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokeApi: PokeApi) {
    suspend fun getPokemonList(): PokemonResponse {
        return pokeApi.getPokemonList()
    }
}