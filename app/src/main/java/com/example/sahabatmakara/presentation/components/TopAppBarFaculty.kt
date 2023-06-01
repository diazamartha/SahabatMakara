package com.example.sahabatmakara.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sahabatmakara.R
import com.example.sahabatmakara.ui.theme.SahabatMakaraTheme
import com.example.sahabatmakara.ui.theme.Yellow100
import com.example.sahabatmakara.ui.theme.Yellow80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarFaculty(
    navController: NavController,
    title: Int
) {
    TopAppBar(
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Yellow100,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        title = {
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 75.dp)
            )
        }
    )
}

@Composable
@Preview(showBackground = true)
fun TopAppBarFacultyPreview() {
    val navController = rememberNavController()
    SahabatMakaraTheme {
        TopAppBarFaculty(
            title = R.string.label_fmipa_bar,
            navController = navController
        )
    }
}
