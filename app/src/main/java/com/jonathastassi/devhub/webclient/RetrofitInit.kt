package com.jonathastassi.devhub.webclient

import com.jonathastassi.devhub.webclient.service.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val URL_BASE = "https://api.github.com/"

class RetrofitInit {

    private val retrofit =  Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val gitHubService: GitHubService get() = retrofit.create(GitHubService::class.java)
}