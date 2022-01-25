package com.example.news_prakash.view

import com.example.news_prakash.model.remote.ArticlesItem

interface OnItemClick {
    fun onclick(articlesItem: ArticlesItem)
}