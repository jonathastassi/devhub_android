package com.jonathastassi.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
                    Profile(
                        photo = painterResource(id = R.drawable.profile),
                        name = "Jonathas Tassi e Silva",
                        user = "jonathastassi",
                        bio = "Software Developer | Flutter | Android | Mobile"
                    )
                }
            }
        }
    }
}

@Composable
fun Profile(photo: Painter, name: String, user: String, bio: String) {
    Column() {
        Image(painter = photo, contentDescription = "Profile image")
        Text(text = name)
        Text(text = user)
        Text(text = bio)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DevHubTheme {
        Profile(
            photo = painterResource(id = R.drawable.profile),
            name = "Jonathas Tassi e Silva",
            user = "jonathastassi",
            bio = "Software Developer | Flutter | Android | Mobile"
        )
    }
}