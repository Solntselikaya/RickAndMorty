package com.example.rickandmorty.feature_characters.presentation.character_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.common.Constants
import com.example.rickandmorty.common.Resource
import com.example.rickandmorty.feature_characters.domain.use_case.get_characters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CharacterListState())
    val state: State<CharacterListState> = _state

    init {
        savedStateHandle.get<Int>(Constants.PARAM_PAGE_NUM)?.let { pageNum ->
            getCharacters(pageNum)
        }
    }

    private fun getCharacters(page: Int) {
        getCharactersUseCase(page).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CharacterListState(
                        characters = result.data?.results ?: emptyList(),
                        pages = result.data?.info?.pages ?: 0,
                        nextPage = result.data?.info?.next?.toInt() ?: -1
                    )
                }
                is Resource.Error -> {
                    _state.value = CharacterListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CharacterListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}