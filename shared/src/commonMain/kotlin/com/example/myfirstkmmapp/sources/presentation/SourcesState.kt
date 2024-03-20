package com.example.myfirstkmmapp.sources.presentation

import com.example.myfirstkmmapp.sources.application.Source

data class SourcesState (
    val sources: List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)