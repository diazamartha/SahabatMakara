package com.example.sahabatmakara.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sahabatmakara.R
import com.example.sahabatmakara.SahabatMakaraApp
import com.example.sahabatmakara.presentation.components.BottomNavigationBar
import com.example.sahabatmakara.presentation.components.MakaraItem
import com.example.sahabatmakara.presentation.navigation.Screen
import com.example.sahabatmakara.ui.theme.SahabatMakaraTheme

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        item{
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                MakaraItem(
                    image = R.drawable.ic_fmipa_ui,
                    title = R.string.label_fmipa,
                    onClick = {
                        navController.navigate(Screen.Fmipa.route)
                    },
                    modifier = Modifier
                        .weight(1f)
                )
                MakaraItem(
                    image = R.drawable.ic_fasilkom_ui,
                    title = R.string.label_fasilkom,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                MakaraItem(
                    image = R.drawable.ic_farmasi_ui,
                    title = R.string.label_farmasi,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
                MakaraItem(
                    image = R.drawable.ic_fe_ui,
                    title = R.string.label_fe,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                MakaraItem(
                    image = R.drawable.ic_fh_ui,
                    title = R.string.label_fh,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
                MakaraItem(
                    image = R.drawable.ic_fia_ui,
                    title = R.string.label_fia,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                MakaraItem(
                    image = R.drawable.ic_fib_ui,
                    title = R.string.label_fib,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
                MakaraItem(
                    image = R.drawable.ic_fik_ui,
                    title = R.string.label_fik,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                MakaraItem(
                    image = R.drawable.ic_fisip_ui,
                    title = R.string.label_fisip,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
                MakaraItem(
                    image = R.drawable.ic_fk_ui,
                    title = R.string.label_fk,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                MakaraItem(
                    image = R.drawable.ic_fkg_ui,
                    title = R.string.label_fkg,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
                MakaraItem(
                    image = R.drawable.ic_fkm_ui,
                    title = R.string.label_fkm,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                MakaraItem(
                    image = R.drawable.ic_fpsi_ui,
                    title = R.string.label_fpsi,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
                MakaraItem(
                    image = R.drawable.ic_ft_ui,
                    title = R.string.label_ft,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                MakaraItem(
                    image = R.drawable.ic_vokasi_ui,
                    title = R.string.label_vokasi,
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }


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

