package com.ifsha.pokemon

import com.ifsha.pokemon.details.PokemonDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemonList(): PokemonResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: Int): PokemonDetails
}