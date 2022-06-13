package com.jonathastassi.devhub.data.datasources

import com.jonathastassi.devhub.data.models.GitHubProfileModel
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("/users/{user}")
    suspend fun findProfileBy(@Path("user") user: String): GitHubProfileModel
}