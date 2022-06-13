package com.jonathastassi.devhub.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.jonathastassi.devhub.data.repositories.GitHubRepository
import com.jonathastassi.devhub.ui.component.ProfileContent
import com.jonathastassi.devhub.ui.mapper.toState

@Composable
fun ProfileScreen(user: String, gitHubRepository: GitHubRepository) {

    val foundUser by gitHubRepository.findProfileBy(user).collectAsState(initial = null)

    foundUser?.let {
        if (it == null) {
            Text(text = "Dados inválidos", modifier = Modifier.fillMaxWidth())
        } else {
            ProfileContent(
                state = it.toState()
            )
        }
    }
}
