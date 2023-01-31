package com.example.rickandmorty.feature_characters.presentation.character_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.common.Constants
import com.example.rickandmorty.common.Resource
import com.example.rickandmorty.feature_characters.domain.use_case.get_character.GetCharacterUseCase
import com.example.rickandmorty.feature_characters.domain.use_case.get_characters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CharacterDetailsState())
    val state: State<CharacterDetailsState> = _state

    init {
        savedStateHandle.get<Int>(Constants.PARAM_CHARACTER_ID)?.let { characterId ->
            getCharacter(characterId)
        }
    }

    private fun getCharacter(characterId: Int) {
        getCharacterUseCase(characterId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CharacterDetailsState(
                        character = result.data
                    )
                }
                is Resource.Error -> {
                    _state.value = CharacterDetailsState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CharacterDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}