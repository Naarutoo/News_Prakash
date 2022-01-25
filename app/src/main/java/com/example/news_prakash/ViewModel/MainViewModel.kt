package com.example.news_prakash.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news_prakash.model.remote.ArticlesItem
import com.example.news_prakash.model.Repo

class MainViewModel(private val repo: Repo) : ViewModel() {
    fun getata():LiveData<List<ArticlesItem>>{
        return repo.getDataFromApi()
    }
}

class ViewModelFactory(private val repo: Repo) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo)as T
    }
}