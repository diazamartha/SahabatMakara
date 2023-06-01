package com.example.sahabatmakara.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sahabatmakara.ui.theme.SahabatMakaraTheme

@Composable
fun PlacesScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Future development",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(top = 280.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PlacesScreenPreview() {
    SahabatMakaraTheme {
        PlacesScreen()
    }
}