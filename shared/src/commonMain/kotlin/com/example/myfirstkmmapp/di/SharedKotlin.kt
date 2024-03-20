package com.example.myfirstkmmapp.di

import com.example.myfirstkmmapp.articles.di.articlesModule
import com.example.myfirstkmmapp.sources.di.sourcesModule

val sharedModules = listOf (
    articlesModule,
    sourcesModule,
    networkModule,
)