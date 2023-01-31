package com.example.rickandmorty.feature_characters.presentation.character_list

import com.example.rickandmorty.feature_characters.domain.model.CharacterShort

data class CharacterListState(
    val isLoading: Boolean = false,
    val pages: Int = 0,
    val nextPage: Int = -1,
    val characters: List<CharacterShort> = emptyList(),
    val error: String = ""
)
