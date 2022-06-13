package com.jonathastassi.devhub.ui.mapper

import com.jonathastassi.devhub.data.models.GitHubProfileModel
import com.jonathastassi.devhub.ui.state.ProfileUiState

fun GitHubProfileModel.toState(): ProfileUiState = ProfileUiState(
        user = this.login ?: "",
        image = this.avatar_url ?: "",
        bio = this.bio ?: "",
        name = this.name ?: "",
    )
