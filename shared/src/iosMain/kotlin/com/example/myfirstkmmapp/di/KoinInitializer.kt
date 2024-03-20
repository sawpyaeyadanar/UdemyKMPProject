package com.example.myfirstkmmapp.di

import com.example.myfirstkmmapp.articles.presentation.ArticlesViewModel
import com.example.myfirstkmmapp.sources.presentation.SourcesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val module = sharedModules + databaseModule

    startKoin {
        modules(module)
    }
}

class ArticlesInjector: KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}

class SourcesInjector: KoinComponent {
    val sourcesViewModel: SourcesViewModel by inject()
}