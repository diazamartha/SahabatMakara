package com.example.sahabatmakara.presentation.screen.detailfaculty.fmipa

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.compose.rememberNavController
import com.example.sahabatmakara.R
import org.koin.androidx.compose.koinViewModel
import com.example.sahabatmakara.presentation.common.Result
import com.example.sahabatmakara.ui.theme.SahabatMakaraTheme
import com.example.sahabatmakara.ui.theme.Yellow100
import org.w3c.dom.Text

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FmipaMajorDetailDialog(
    onDismiss: () -> Unit,
    major: String,
    fmipaViewModel: FmipaViewModel = koinViewModel()
) {
    val context = LocalContext.current
    fmipaViewModel.fmipaMajorDetail.collectAsState(initial = Result.Loading).value.let{ fmipaMajorDetail ->
        when(fmipaMajorDetail) {
            is Result.Loading -> {
                fmipaViewModel.getDetailFmipaMajor(major)
            }
            is Result.Success -> {
                val data = fmipaMajorDetail.data
                Dialog(
                    onDismissRequest = {
                        onDismiss()
                    },
                    properties = DialogProperties(
                        usePlatformDefaultWidth = false
                    )
                ) {
                    Card(
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        ),
                        shape = RoundedCornerShape(18.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .border(
                                1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(18.dp)
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                        ) {
                            Text(
                                text = stringResource(R.string.action_close),
                                style = MaterialTheme.typography.headlineMedium.copy(
                                    color = Yellow100
                                ),
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .padding(bottom = 26.dp)
                                    .clickable { onDismiss() }
                            )
                            Image(
                                painter = painterResource(data.image),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(60.dp)
                                    .align(Alignment.CenterHorizontally)
                                    .clip(CircleShape)
                            )
                            Text(
                                text = data.major,
                                style = MaterialTheme.typography.headlineMedium.copy(
                                    color = MaterialTheme.colorScheme.onBackground
                                ),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .padding(top = 25.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 25.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                ) {
                                    Text(
                                        text = stringResource(R.string.label_dept),
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            color = Color.LightGray
                                        ),
                                        modifier = Modifier.align(Alignment.CenterHorizontally)
                                    )
                                    Text(
                                        text = data.dept,
                                        style = MaterialTheme.typography.headlineMedium.copy(
                                            color = MaterialTheme.colorScheme.onBackground
                                        ),
                                        modifier = Modifier.align(Alignment.CenterHorizontally)
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                ) {
                                    Text(
                                        text = stringResource(R.string.label_faculty),
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            color = Color.LightGray
                                        ),
                                        modifier = Modifier.align(Alignment.CenterHorizontally)
                                    )
                                    Text(
                                        text = data.faculty,
                                        style = MaterialTheme.typography.headlineMedium.copy(
                                            color = MaterialTheme.colorScheme.onBackground
                                        ),
                                        modifier = Modifier.align(Alignment.CenterHorizontally)
                                    )
                                }
                            }

                            Divider(
                                modifier = Modifier.padding(top = 25.dp)
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Description",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Color.LightGray
                                    ),
                                    modifier = Modifier
                                        .padding(top = 26.dp)
                                        .align(Alignment.CenterHorizontally),

                                )
                                Text(
                                    text = data.description,
                                    style = MaterialTheme.typography.headlineMedium.copy(
                                        color = Color.Gray
                                    ),
                                    modifier = Modifier
                                        .padding(top = 2.dp)
                                        .align(Alignment.CenterHorizontally),
                                    textAlign = TextAlign.Center

                                )
                            }

                        }
                    }
                }
            }
            is Result.Error -> {}
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FmipaMajorDetailDialogPreview() {
    val navController = rememberNavController()
    SahabatMakaraTheme {
        FmipaMajorDetailDialog(onDismiss = { /*TODO*/ }, major = "")
    }
}