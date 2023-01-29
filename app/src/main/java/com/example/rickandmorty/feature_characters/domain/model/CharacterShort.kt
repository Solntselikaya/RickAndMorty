package com.example.rickandmorty.feature_characters.domain.model

data class CharacterShort(
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String
)
