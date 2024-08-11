package com.ifsha.pokemon.details.model

import com.google.gson.annotations.SerializedName

data class PokemonDetails(
    @SerializedName("abilities"       ) var abilities      : ArrayList<Abilities> = arrayListOf(),
    @SerializedName("base_experience" ) var baseExperience : Int?                 = null,
    @SerializedName("cries"           ) var cries          : Cries?               = Cries(),
    @SerializedName("height"          ) var height         : Int?                 = null,
    @SerializedName("id"              ) var id             : Int?                 = null,
    @SerializedName("name"            ) var name           : String?              = null,
    @SerializedName("sprites"         ) var sprites        : Sprites?             = Sprites(),
    @SerializedName("weight"          ) var weight         : Int?                 = null,
    @SerializedName("moves"           ) var moves          : ArrayList<Moves>     = arrayListOf()
)

