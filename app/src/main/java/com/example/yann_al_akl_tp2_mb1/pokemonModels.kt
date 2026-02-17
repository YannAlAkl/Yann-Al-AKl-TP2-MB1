package com.example.yannalakl_mb1c7_tp2

// Utilisation de parenthèses pour le constructeur et String avec une majuscule
data class PokemonResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)
