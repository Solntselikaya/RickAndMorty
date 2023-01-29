package com.example.rickandmorty.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var route: String, var icon: ImageVector, var title: String) {
    object Character : BottomNavItem("character", Icons.Outlined.AccountCircle, "Characters")
    object Location : BottomNavItem("location", Icons.Outlined.Place, "Locations")
    object Episode : BottomNavItem("episode", Icons.Outlined.PlayArrow, "Episodes")
}