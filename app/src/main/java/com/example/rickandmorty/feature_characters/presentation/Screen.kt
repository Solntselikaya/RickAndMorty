package com.example.rickandmorty.feature_characters.presentation

sealed class Screen(val route: String) {
    object CharacterListScreen: Screen("character_list_screen")
    object CharacterDetailsScreen: Screen("character_details_screen")
}
