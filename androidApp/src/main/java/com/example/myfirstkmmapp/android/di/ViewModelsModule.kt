package com.example.myfirstkmmapp.android.di

import com.example.myfirstkmmapp.articles.presentation.ArticlesViewModel
import com.example.myfirstkmmapp.sources.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(get()) }
    viewModel { SourcesViewModel(get()) }
}