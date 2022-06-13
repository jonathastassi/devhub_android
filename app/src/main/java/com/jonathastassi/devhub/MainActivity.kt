package com.jonathastassi.devhub

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jonathastassi.devhub.data.repositories.GitHubRepository
import com.jonathastassi.devhub.ui.theme.DevHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileScreen(
                        user = "jonathastassi",
                        gitHubRepository = GitHubRepository()
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(user: String, gitHubRepository: GitHubRepository) {

    val foundUser by gitHubRepository.findProfileBy(user).collectAsState(initial = null)

    foundUser?.let {
        if (it == null) {
            Text(text = "Dados inválidos", modifier = Modifier.fillMaxWidth())
        } else {
            val boxHeight = remember {
                150.dp
            }
            val imageHeight = remember {
                (boxHeight.value).dp
            }
            Column(
                modifier = Modifier.background(color = Color.White)
            ) {

                Box(
                    contentAlignment = BottomCenter
                ) {
                    Column() {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(boxHeight)
                                .background(
                                    color = Color.DarkGray,
                                    shape = RoundedCornerShape(0.dp, 0.dp, 18.dp, 18.dp)
                                )
                        )
                        Spacer(modifier = Modifier.height((imageHeight.value / 2).dp))
                    }
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(it.avatar_url)
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(R.drawable.user),
                        contentDescription = "Profile image",
                        modifier = Modifier
                            .background(color = Color.White, shape = CircleShape)
                            .clip(
                                CircleShape
                            )
                            .height(imageHeight)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = it.name,
                        style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.W500)
                    )
                    Text(
                        text = user,
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W900)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = it.bio ?: "")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DevHubTheme {
        ProfileScreen(
            user = "jonathastassi",
            gitHubRepository = GitHubRepository()
        )
    }
}