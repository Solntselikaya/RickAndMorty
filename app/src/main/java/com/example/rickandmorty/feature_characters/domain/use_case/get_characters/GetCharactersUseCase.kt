package com.example.rickandmorty.feature_characters.domain.use_case.get_characters

import com.example.rickandmorty.common.Resource
import com.example.rickandmorty.feature_characters.data.remote.dto.toCharacters
import com.example.rickandmorty.feature_characters.domain.model.CharacterShort
import com.example.rickandmorty.feature_characters.domain.model.Characters
import com.example.rickandmorty.feature_characters.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    operator fun invoke(page: Int): Flow<Resource<Characters>> = flow {
        try {
            emit(Resource.Loading())
            val characters = repository.getCharacters(page).toCharacters()
            emit(Resource.Success(characters))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}