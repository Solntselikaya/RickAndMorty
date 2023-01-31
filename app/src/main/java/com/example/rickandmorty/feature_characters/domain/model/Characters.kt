package com.example.rickandmorty.feature_characters.domain.model

data class Characters (
    val info: PageInfo,
    val results: List<CharacterShort>
)