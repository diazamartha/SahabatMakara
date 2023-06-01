package com.example.sahabatmakara.presentation.screen.detailfaculty.fmipa

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sahabatmakara.R
import com.example.sahabatmakara.data.source.FmipaMajorData.fmipaListMajor
import com.example.sahabatmakara.presentation.common.Result
import com.example.sahabatmakara.presentation.components.MajorItem
import com.example.sahabatmakara.presentation.components.TopAppBarFaculty
import com.example.sahabatmakara.ui.theme.SahabatMakaraTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun FmipaScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    fmipaViewModel: FmipaViewModel = koinViewModel()
) {

    Scaffold(
        topBar = { TopAppBarFaculty(
            navController = navController, title = R.string.label_fmipa_bar
        ) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            val listState = rememberLazyListState()

            fmipaViewModel.fmipaMajor.collectAsState(initial = Result.Loading).value.let { fmipaMajors ->
                when(fmipaMajors) {
                    is Result.Loading -> {
                        fmipaViewModel.getFmipaMajor()
                    }
                    is Result.Success -> {
                        LazyColumn(
                            state = listState
                        ) {
                            items(fmipaListMajor, key = { it.major }) { major ->
                                MajorItem(
                                    image = major.image,
                                    major = major.major,
                                    dept = major.dept,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .animateItemPlacement(tween(durationMillis = 100)),
                                    fmipaViewModel = fmipaViewModel,
                                    major
                                )
                            }
                        }
                    }
                    is Result.Error -> {}
                }
            }
        }
        if (fmipaViewModel.isDialogShown) {
            FmipaMajorDetailDialog(
                onDismiss = { fmipaViewModel.onDismissDialog() },
                major = fmipaViewModel.getSelectedEmployeeUuid(),
                fmipaViewModel = fmipaViewModel
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FmipaScreenPreview() {
    val navController = rememberNavController()
    SahabatMakaraTheme() {
        FmipaScreen(navController = navController)
    }
}
