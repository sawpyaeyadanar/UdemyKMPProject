package com.example.myfirstkmmapp.articles.di

import com.example.myfirstkmmapp.articles.data.ArticleService
import com.example.myfirstkmmapp.articles.data.ArticlesDataSource
import com.example.myfirstkmmapp.articles.data.ArticlesRepository
import com.example.myfirstkmmapp.articles.application.ArticlesUseCase
import com.example.myfirstkmmapp.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticleService> { ArticleService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}