package com.jonathastassi.devhub.data.repositories

import com.jonathastassi.devhub.data.RetrofitInit
import com.jonathastassi.devhub.data.datasources.GitHubApi
import kotlinx.coroutines.flow.flow

class GitHubRepository(
    private val gitHubApi: GitHubApi = RetrofitInit().gitHubApi
) {

    fun findProfileBy(user: String) = flow {
        emit(gitHubApi.findProfileBy(user))
    }
}