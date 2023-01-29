package com.example.rickandmorty.feature_characters.data.remote

import com.example.rickandmorty.feature_characters.data.remote.dto.CharacterDetailsDto
import com.example.rickandmorty.feature_characters.data.remote.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {

    @GET("/character")
    suspend fun getCharacters(@Query("page") page: Int): CharactersDto

    @GET("/character/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId: Int): CharacterDetailsDto

    // TODO: need to add request for search later
}