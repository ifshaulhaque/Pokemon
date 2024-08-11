package com.ifsha.pokemon.details.model

import com.google.gson.annotations.SerializedName


data class Moves (

  @SerializedName("move" ) var move : Move? = Move()

)