package com.example.sahabatmakara.presentation.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash")
}
