package com.example.sahabatmakara.presentation.screen.detailfaculty.fmipa

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sahabatmakara.R
import com.example.sahabatmakara.data.source.FmipaMajorData.fmipaListMajor
import com.example.sahabatmakara.di.facultyModule
import com.example.sahabatmakara.domain.model.FmipaMajor
import com.example.sahabatmakara.domain.model.UiMajor
import com.example.sahabatmakara.presentation.common.Result
import com.example.sahabatmakara.presentation.components.MajorItem
import com.example.sahabatmakara.presentation.components.TopAppBarFaculty
import com.example.sahabatmakara.ui.theme.SahabatMakaraTheme
import com.example.sahabatmakara.ui.theme.Yellow20
import com.example.sahabatmakara.ui.theme.Yellow80
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

            SearchBar(
                query = "",
                onQueryChange = {},
                modifier = modifier
            )
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
                                        .animateItemPlacement(tween(durationMillis = 100))
                                )
                            }
                        }
                    }
                    is Result.Error -> {}
                }
            }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 6.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = {
                Text(
                    text = stringResource(R.string.hint_find_major),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Light
                    ),
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(vertical = 2.dp)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors =  TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.surface,
                disabledBorderColor = Color.Transparent,
                focusedBorderColor = Yellow80,
                unfocusedBorderColor = Color.Transparent,
            ),
            maxLines = 1,
            modifier = modifier
                .border(1.dp, color = Yellow20, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .heightIn(min = 43.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SahabatMakaraTheme() {
        SearchBar(
            query = "",
            onQueryChange = {}
        )
    }
}