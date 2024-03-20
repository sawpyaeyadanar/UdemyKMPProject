package com.example.myfirstkmmapp.sources.data

import com.example.myfirstkmmapp.articles.data.apiKey
import com.example.myfirstkmmapp.sources.data.SourcesRaw
import com.example.myfirstkmmapp.sources.data.SourcesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(private val httpClient: HttpClient) {
    suspend fun fetchSources(): List<SourcesRaw> {
        val response: SourcesResponse = httpClient.get("https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey").body()
        return response.sources
    }
}