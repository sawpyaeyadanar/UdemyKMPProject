package com.example.myfirstkmmapp.articles.data

import com.example.myfirstkmmapp.articles.data.ArticleRaw
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse (
    @SerialName("status") val status: String,
    @SerialName("totalResults") val results: Int,
    @SerialName("articles") val articles: List<ArticleRaw>
)
