package com.example.sahabatmakara.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sahabatmakara.R
import com.example.sahabatmakara.domain.model.FmipaMajor
import com.example.sahabatmakara.ui.theme.SahabatMakaraTheme
import com.example.sahabatmakara.ui.theme.Yellow80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MajorItem(
    image: Int,
    major: String,
    dept: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .padding(vertical = 6.dp, horizontal = 16.dp)
            .clickable { },
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(1.dp, color = Yellow80)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "major",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(12.dp)
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp)
            ) {
                Text(
                    text = major,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, bottom = 4.dp)
                )
                Text(
                    text = dept,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Light
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmployeesItemPreview() {
    SahabatMakaraTheme() {
        MajorItem(
            R.drawable.ic_geologi,
            stringResource(R.string.label_geologi),
            stringResource(R.string.label_dept_geosains)
        )
    }
}