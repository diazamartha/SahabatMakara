package com.example.sahabatmakara.presentation.screen.aboutme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sahabatmakara.R
import com.example.sahabatmakara.ui.theme.SahabatMakaraTheme

@Composable
fun AboutMeScreen(
    modifier: Modifier = Modifier,
    navCotroller: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_profile),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(R.string.label_name),
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 25.dp)
        )
        Text(
            text = stringResource(R.string.label_email),
            style = MaterialTheme.typography.headlineMedium.copy(
                color = Color.Blue, fontStyle = FontStyle.Italic
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 12.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(R.string.label_university),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(R.string.label_university_name),
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = MaterialTheme.colorScheme.onBackground
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(85.dp),
                    maxLines = 3,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(R.string.label_major),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(R.string.label_geologi),
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = MaterialTheme.colorScheme.onBackground
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AboutMeScreenPreview() {
    val navController = rememberNavController()
    SahabatMakaraTheme {
        AboutMeScreen(navCotroller = navController)
    }
}