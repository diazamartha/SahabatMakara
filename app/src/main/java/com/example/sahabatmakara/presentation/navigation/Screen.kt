package com.example.sahabatmakara.presentation.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash")
    object Home: Screen("home")
    object AboutMe: Screen("about_me")
    object Places: Screen("places")
    object Fmipa: Screen("fmipa")
}
