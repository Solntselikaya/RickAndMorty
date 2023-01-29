package com.example.rickandmorty.feature_characters.data.remote.dto

data class CharactersDto(
    val info: PageInfoDto,
    val results: List<CharacterDto>
)