package com.example.rickandmorty.feature_characters.data.remote.dto

import com.example.rickandmorty.feature_characters.domain.model.PageInfo

data class PageInfoDto(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

fun PageInfoDto.toPageInfo(): PageInfo {
    return PageInfo(
        next = next,
        pages = pages
    )
}