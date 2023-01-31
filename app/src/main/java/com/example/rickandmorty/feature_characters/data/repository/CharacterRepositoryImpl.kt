package com.example.rickandmorty.feature_characters.data.repository

import com.example.rickandmorty.feature_characters.data.remote.CharacterApi
import com.example.rickandmorty.feature_characters.data.remote.dto.CharacterDetailsDto
import com.example.rickandmorty.feature_characters.data.remote.dto.CharactersDto
import com.example.rickandmorty.feature_characters.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterApi
) : CharacterRepository {

    override suspend fun getCharacters(page: Int): CharactersDto {
        return api.getCharacters(page)
    }

    override suspend fun getCharacterById(coinId: Int): CharacterDetailsDto {
        return api.getCharacterById(coinId)
    }
}