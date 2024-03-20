package com.example.myfirstkmmapp.sources.data

import sevenpeaks.kmm.news.db.KMMDatabase

class SourcesDataSource(private val database: KMMDatabase) {
    private fun mapToSourceRaw( id: String, name: String, description: String, language: String, country: String): SourcesRaw = SourcesRaw(id, name, description, language , country )

    fun getAllSources(): List<SourcesRaw> = database.kMMDatabaseQueries.selectAllSources(::mapToSourceRaw).executeAsList()

    fun insertSources(sources: List<SourcesRaw>) {
        database.kMMDatabaseQueries.transaction {
            sources.forEach {
                insertSource(it)
            }
        }
    }

    private fun insertSource(sources: SourcesRaw) {
        database.kMMDatabaseQueries.insertSource(sources.id, sources.name, sources.description, sources.language, sources.country)
    }

    fun clearSources() = database.kMMDatabaseQueries.removeAllSources()
}

