package com.example.rickandmorty.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmorty.ui.theme.Gray

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Character.route
    ) {

        composable(BottomNavItem.Character.route) {
            Text("Work on this screen now", color = Gray)
        }

        composable(BottomNavItem.Location.route) {
            Text("Will add content soon!", color = Gray)
        }

        composable(BottomNavItem.Episode.route) {
            Text("Will add content soon!", color = Gray)
        }
    }
}