package com.ifsha.pokemon.details

import com.google.gson.annotations.SerializedName


data class Abilities (

  @SerializedName("ability" ) var ability : Ability? = Ability()

)