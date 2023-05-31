package com.example.sahabatmakara.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sahabatmakara.R
import com.example.sahabatmakara.ui.theme.SahabatMakaraTheme
import com.example.sahabatmakara.ui.theme.Yellow20

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MakaraItem(
    modifier: Modifier = Modifier,
    image: Int,
    title: Int,
    onClick: () -> Unit,
    ) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .width(150.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Yellow20)
    ) {
        Column(modifier = Modifier
            .background(Color.White)
            .clip(RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Column(
                modifier = Modifier
                    .background(Yellow20)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(title),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 16.dp)
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun MakaraItemPreview() {
    SahabatMakaraTheme() {
        MakaraItem(
            image = R.drawable.ic_fmipa_ui,
            title = R.string.label_fmipa,
            onClick = {},
            modifier = Modifier.padding(22.dp)
        )
    }
}