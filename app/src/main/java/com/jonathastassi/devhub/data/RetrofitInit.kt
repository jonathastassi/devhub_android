package com.jonathastassi.devhub.data

import com.jonathastassi.devhub.data.datasources.GitHubApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val URL_BASE = "https://api.github.com/"

class RetrofitInit {

    private val retrofit =  Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val gitHubApi: GitHubApi get() = retrofit.create(GitHubApi::class.java)
}