package com.example.myfirstkmmapp.articles.data

class ArticlesRepository(private val dataSource: ArticlesDataSource, private  val service: ArticleService) {
    suspend fun getArticles(forceFetch: Boolean) : List<ArticleRaw> {
        if (forceFetch) {
            dataSource.clearArticles()
            return fetchArticles()
        }

        val articlesDB = dataSource.getAllArticles()
        println("Got ${articlesDB.size} from the DB")
        if (articlesDB.isEmpty()) {
            return fetchArticles()
        }
        return articlesDB
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchArticles = service.fetchArticles()
        dataSource.insertArticles(fetchArticles)
        return fetchArticles
    }
 }