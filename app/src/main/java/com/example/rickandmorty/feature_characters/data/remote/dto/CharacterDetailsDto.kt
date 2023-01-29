package com.example.rickandmorty.feature_characters.data.remote.dto

import com.example.rickandmorty.feature_characters.domain.model.Character
import com.example.rickandmorty.feature_characters.domain.model.CharacterShort

data class CharacterDetailsDto(
    val created: String,
    val episodes: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterDetailsDto.toCharacter(): Character {
    return Character(
        episodes = episodes,
        gender = gender,
        image = image,
        location = location,
        name = name,
        origin = origin,
        species = species,
        status = status,
        type = type
    )
}

fun CharacterDetailsDto.toCharacterShort(): CharacterShort {
    return CharacterShort(
        gender = gender,
        id = id,
        image = image,
        name = name,
        species = species,
        status = status
    )
}