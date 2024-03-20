package com.example.myfirstkmmapp.articles.presentation

import com.example.myfirstkmmapp.articles.application.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)