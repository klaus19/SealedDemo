package com.example.sealeddemo.api

import com.example.sealeddemo.model.PopularArticlesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ExampleApiService {

    @GET("example/popular_articles")
    suspend fun fetchPopularArticles():Response<PopularArticlesResponse>

}