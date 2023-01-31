package com.example.rickandmorty.feature_characters.domain.repository

import com.example.rickandmorty.feature_characters.data.remote.dto.CharacterDetailsDto
import com.example.rickandmorty.feature_characters.data.remote.dto.CharactersDto

interface CharacterRepository {

    suspend fun getCharacters(page: Int): CharactersDto

    suspend fun getCharacterById(coinId: Int): CharacterDetailsDto
}