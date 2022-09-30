package com.example.sealeddemo.repository

import com.example.sealeddemo.api.ExampleApiService
import com.example.sealeddemo.model.PopularArticlesResponse
import com.example.sealeddemo.network.Resource

class ExampleRepo(private val apiService: ExampleApiService):BaseRepo() {

    suspend fun getPopularArticles():Resource<PopularArticlesResponse>{
        // Passing 'api.fetchPopularArticles()' function
        // as an argument in safeApiCall function
        return safeApiCall { apiService.fetchPopularArticles() }
    }
}