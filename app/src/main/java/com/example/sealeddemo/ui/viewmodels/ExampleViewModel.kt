package com.example.sealeddemo.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sealeddemo.model.PopularArticlesResponse
import com.example.sealeddemo.network.Resource
import com.example.sealeddemo.repository.ExampleRepo
import kotlinx.coroutines.launch

class ExampleViewModel(private val exampleRepo: ExampleRepo):ViewModel() {

    private val _popularArticles = MutableLiveData<Resource<PopularArticlesResponse>>()
    val popularArticles:LiveData<Resource<PopularArticlesResponse>> = _popularArticles

    init {
        getPopularArticles()
    }

    private fun getPopularArticles() = viewModelScope.launch {

        // Firstly we are posting
        // Loading state in mutableLiveData
        _popularArticles.postValue(Resource.Loading())

        //posting response as it becomes ready
        _popularArticles.postValue(exampleRepo.getPopularArticles())
    }
}