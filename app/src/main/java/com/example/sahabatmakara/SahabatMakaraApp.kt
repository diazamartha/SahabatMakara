package com.example.sahabatmakara

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sahabatmakara.di.facultyModule
import com.example.sahabatmakara.di.viewModelModule
import com.example.sahabatmakara.presentation.components.BottomNavigationBar
import com.example.sahabatmakara.presentation.navigation.Screen
import com.example.sahabatmakara.presentation.screen.PlacesScreen
import com.example.sahabatmakara.presentation.screen.aboutme.AboutMeScreen
import com.example.sahabatmakara.presentation.screen.detailfaculty.fmipa.FmipaScreen
import com.example.sahabatmakara.presentation.screen.home.HomeScreen
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SahabatMakaraApp(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val koinApplication = remember {
        startKoin {
            androidLogger()
            modules(facultyModule, viewModelModule)
        }
    }

    Scaffold(
        bottomBar = {
            if (listOf(
                    Screen.Home.route,
                    Screen.Places.route,
                    Screen.AboutMe.route
            ).any { it == currentRoute }) BottomNavigationBar(navController = navController)
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController as NavHostController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Splash.route) {

            }
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Screen.Places.route) {
                PlacesScreen()
            }
            composable(Screen.AboutMe.route) {
                AboutMeScreen(navCotroller = navController)
            }
            composable(Screen.Fmipa.route) {
                FmipaScreen(navController = navController)
            }
        }

    }

    DisposableEffect(Unit) {
        onDispose {
            koinApplication.koin
        }
    }
}