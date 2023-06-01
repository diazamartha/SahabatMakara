package com.example.sahabatmakara.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sahabatmakara.R
import com.example.sahabatmakara.presentation.components.MakaraItem
import com.example.sahabatmakara.presentation.navigation.Screen
import com.example.sahabatmakara.ui.theme.SahabatMakaraTheme

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MakaraItem(
            image = R.drawable.ic_fmipa_ui,
            title = R.string.label_fmipa,
            onClick = {
                navController.navigate(Screen.Fmipa.route)
            },
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    val navController = rememberNavController()
    SahabatMakaraTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            HomeScreen(navController = navController)
        }
    }
}

