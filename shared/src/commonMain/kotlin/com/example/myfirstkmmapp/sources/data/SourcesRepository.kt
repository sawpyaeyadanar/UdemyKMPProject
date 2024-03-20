package com.example.myfirstkmmapp.sources.data

class SourcesRepository(private val dataSource: SourcesDataSource, private val service: SourcesService) {
    suspend fun getSources(): List<SourcesRaw> {
    val sourcesDB = dataSource.getAllSources()
        println("Got sourceDB ${sourcesDB.size} from the DB")
        if(sourcesDB.isEmpty()) {
            dataSource.clearSources()
            return fetchSources()
        }
        return sourcesDB
    }

    private suspend fun fetchSources(): List<SourcesRaw> {
        val fetchSources = service.fetchSources()
        dataSource.insertSources(fetchSources)
        return fetchSources
    }
}