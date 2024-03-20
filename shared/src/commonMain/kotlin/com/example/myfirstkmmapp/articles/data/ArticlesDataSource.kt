package com.example.myfirstkmmapp.articles.data

import sevenpeaks.kmm.news.db.KMMDatabase

class ArticlesDataSource(private val database: KMMDatabase) {

    private fun mapToArticleRaw( title: String, desc: String?, date: String, url: String?): ArticleRaw = ArticleRaw(title, desc, date, url)

    fun getAllArticles(): List<ArticleRaw>  = database.kMMDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.kMMDatabaseQueries.transaction {
            articles.forEach {
                insertArticle(it)
            }
        }
    }

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.kMMDatabaseQueries.insertArticle( articleRaw.title, articleRaw.desc, articleRaw.date, articleRaw.imageUrl)
    }

    fun clearArticles() = database.kMMDatabaseQueries.removeAllArticles()
}