package com.example.rickandmorty.feature_characters.presentation.character_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.rickandmorty.feature_characters.presentation.Screen
import com.example.rickandmorty.feature_characters.presentation.character_list.components.CharacterListItem

@Composable
fun CharacterListScreen(
    navController: NavController,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.characters) { character ->
                CharacterListItem(
                    character = character,
                    onItemClick = {
                        navController.navigate(Screen.CharacterDetailsScreen.route + "/${character.id}")
                    }
                )
            }
        }

        if (state.error.isNotBlank()) {

        }
    }
}