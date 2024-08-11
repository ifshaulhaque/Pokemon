package com.ifsha.pokemon.network

import com.ifsha.pokemon.list.model.PokemonResponse
import com.ifsha.pokemon.details.model.PokemonDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemonList(): PokemonResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: Int): PokemonDetails
}