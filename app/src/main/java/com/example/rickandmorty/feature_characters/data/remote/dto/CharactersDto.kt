package com.example.rickandmorty.feature_characters.data.remote.dto

import com.example.rickandmorty.feature_characters.domain.model.Characters

data class CharactersDto(
    val info: PageInfoDto,
    val results: List<CharacterDetailsDto>
)

fun CharactersDto.toCharacters(): Characters {
    return Characters (
        info = info.toPageInfo(),
        results = results.map { it.toCharacterShort() }
    )
}