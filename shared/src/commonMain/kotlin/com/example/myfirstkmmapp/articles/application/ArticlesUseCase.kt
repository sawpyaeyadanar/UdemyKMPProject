package com.example.myfirstkmmapp.articles.application

import com.example.myfirstkmmapp.articles.data.ArticleRaw
import com.example.myfirstkmmapp.articles.data.ArticlesRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val repo: ArticlesRepository) {

    suspend fun getArticles(forceFetch: Boolean): List<Article> {
        val articlesRaw = repo.getArticles(forceFetch)
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map {
        Article(
            it.title,
            it.desc ?: "Click to find out more",
            getDaysAgoString(it.date),
            it.imageUrl ?: "https://images.ctfassets.net/lzny33ho1g45/T5qqQQVznbZaNyxmHybDT/5f7580349045322d572a078262bee1b8/Best_URL_shortener.jpg?w=1520&fm=jpg&q=30&fit=thumb&h=760"
        )
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) >1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }
        return  result
    }
}