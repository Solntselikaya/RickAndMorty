package com.example.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rickandmorty.navigation.BottomNavItem
import com.example.rickandmorty.navigation.Navigation
import com.example.rickandmorty.ui.theme.Gray
import com.example.rickandmorty.ui.theme.Green
import com.example.rickandmorty.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    RickAndMortyTheme() {
        Scaffold(
            bottomBar = { BottomNavBar(navController) },
            content = { Navigation(navController) },
            backgroundColor = Black
        )
    }
}

@Composable
fun BottomNavBar(navController: NavController) {

    val items = listOf(
        BottomNavItem.Character,
        BottomNavItem.Location,
        BottomNavItem.Episode
    )

    BottomNavigation(
        Modifier.height(68.dp),
        backgroundColor = Gray,
        contentColor = Black
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.title,
                        Modifier.padding(0.dp, 11.dp, 0.dp, 7.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.button
                    )
                },
                selectedContentColor = Green,
                unselectedContentColor = Black,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(BottomNavItem.Character.route) {
                                saveState = true
                                inclusive = false
                            }
                        }
                        restoreState = false
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}