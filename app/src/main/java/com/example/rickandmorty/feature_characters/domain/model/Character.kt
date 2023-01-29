package com.example.rickandmorty.feature_characters.domain.model

import com.example.rickandmorty.feature_characters.data.remote.dto.LocationDto
import com.example.rickandmorty.feature_characters.data.remote.dto.OriginDto

data class Character(
    val episodes: List<String>,
    val gender: String,
    val image: String,
    val location: LocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String
)
