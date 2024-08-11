package com.ifsha.pokemon

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val repository: PokemonRepository) :
    ViewModel() {

    val pokemonList = mutableStateOf<List<PokemonResult>>(emptyList())

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            try {
                val response = repository.getPokemonList()
                val list = ArrayList<PokemonResult>()
                list.addAll(response.results)
                pokemonList.value = list
            } catch (e: Exception) {
                Log.e("API ERROR",e.message.toString())
            }
        }
    }
}