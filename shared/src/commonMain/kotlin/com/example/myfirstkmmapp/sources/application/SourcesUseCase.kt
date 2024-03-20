package com.example.myfirstkmmapp.sources.application

import com.example.myfirstkmmapp.sources.data.SourcesRaw
import com.example.myfirstkmmapp.sources.data.SourcesRepository

class SourcesUseCase(private val repo: SourcesRepository) {
    suspend fun getSources(): List<Source> {
        val sourceRaw =  repo.getSources()
        return mapSources(sourceRaw)
    }

    private fun mapSources(sourceRaw: List<SourcesRaw>): List<Source> {
        return  sourceRaw.map {
            Source(it.id, it.name, it.description, mapOrigin(it))
        }
    }

    private fun mapOrigin(raw: SourcesRaw) = "${raw.country} - ${raw.language}"

}