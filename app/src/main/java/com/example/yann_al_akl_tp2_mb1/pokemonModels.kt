package com.example.yann_al_akl_tp2_mb1

data class PokemonResponse(
    val results: List<PokemonResult>
)

data class PokemonResult(
    val national_number: String,
    val evolution: Evolution?,
    val sprites: Sprites?,
    val name: String,
    val type: List<String>,
    val total: Int,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val sp_atk: Int,
    val sp_def: Int,
    val speed: Int
)

data class Evolution(
    val name: String
)

data class Sprites(
    val normal: String,
    val large: String?,
    val animated: String?
)
