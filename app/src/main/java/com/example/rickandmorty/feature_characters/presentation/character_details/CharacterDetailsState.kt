package com.example.rickandmorty.feature_characters.presentation.character_details

import com.example.rickandmorty.feature_characters.domain.model.Character

data class CharacterDetailsState(
    val isLoading: Boolean = false,
    val character: Character? = null,
    val error: String = ""
)
