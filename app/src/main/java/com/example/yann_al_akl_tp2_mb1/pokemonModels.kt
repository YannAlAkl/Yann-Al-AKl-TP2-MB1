package com.example.yann_al_akl_tp2_mb1

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
