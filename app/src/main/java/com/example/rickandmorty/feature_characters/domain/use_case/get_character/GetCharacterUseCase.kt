package com.example.rickandmorty.feature_characters.domain.use_case.get_character

import com.example.rickandmorty.common.Resource
import com.example.rickandmorty.feature_characters.data.remote.dto.toCharacter
import com.example.rickandmorty.feature_characters.domain.repository.CharacterRepository
import com.example.rickandmorty.feature_characters.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    operator fun invoke(characterId: Int): Flow<Resource<Character>> = flow {
        try {
            emit(Resource.Loading())
            val character = repository.getCharacterById(characterId).toCharacter()
            emit(Resource.Success(character))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}