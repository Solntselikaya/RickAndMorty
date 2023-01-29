package com.example.rickandmorty.feature_characters.data.remote.dto

data class PageInfoDto(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)