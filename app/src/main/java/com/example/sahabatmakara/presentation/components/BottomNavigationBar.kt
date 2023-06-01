package com.example.sahabatmakara.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sahabatmakara.R
import com.example.sahabatmakara.presentation.navigation.Screen
import com.example.sahabatmakara.ui.theme.SahabatMakaraTheme
import com.example.sahabatmakara.ui.theme.Yellow20
import com.example.sahabatmakara.ui.theme.Yellow80

@Composable
fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    
    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 82.dp)
            .background(Color.White)
            .shadow(elevation = 1.dp)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        BottomNavigationBarItem(
            isSelected = currentRoute == Screen.Home.route,
            icon = Icons.Default.Home,
            label = stringResource(R.string.label_home_navigation_bar),
            onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) {
                        saveState = true
                    }
                    restoreState = true
                    launchSingleTop = true
                }
            },
            modifier = Modifier.weight(1f),
            iconModifier = Modifier.size(36.dp)
        )
        BottomNavigationBarItem(
            isSelected = currentRoute == Screen.Places.route,
            icon = Icons.Default.Place,
            label = stringResource(R.string.label_places_navigation_bar),
            onClick = {
                navController.navigate(Screen.Places.route) {
                    popUpTo(Screen.Home.route) {
                        saveState = true
                    }
                    restoreState = true
                    launchSingleTop = true
                }
            },
            modifier = Modifier.weight(1f),
            iconModifier = Modifier.size(36.dp)
        )
        BottomNavigationBarItem(
            isSelected = currentRoute == Screen.AboutMe.route,
            icon = Icons.Default.AccountCircle,
            label = stringResource(R.string.label_about_me_navigation_bar),
            onClick = {
                navController.navigate(Screen.AboutMe.route) {
                    popUpTo(Screen.Home.route) {
                        saveState = true
                    }
                    restoreState = true
                    launchSingleTop = true
                }
            },
            modifier = Modifier.weight(1f),
            iconModifier = Modifier.size(36.dp)
        )
    }
}

@Composable
fun BottomNavigationBarItem(
    isSelected: Boolean,
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .heightIn(min = 32.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = iconModifier,
            tint = if (isSelected) Yellow80 else Yellow20
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = if (isSelected) Color.Black else Color.LightGray
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BottomNavigationBarPreview() {
    val navController = rememberNavController()
    SahabatMakaraTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            BottomNavigationBar(
                navController = navController,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}