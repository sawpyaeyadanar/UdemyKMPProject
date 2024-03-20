package com.example.myfirstkmmapp.sources.di

import com.example.myfirstkmmapp.sources.data.SourcesRepository
import com.example.myfirstkmmapp.sources.data.SourcesService
import com.example.myfirstkmmapp.sources.application.SourcesUseCase
import com.example.myfirstkmmapp.sources.data.SourcesDataSource
import com.example.myfirstkmmapp.sources.presentation.SourcesViewModel
import org.koin.dsl.module
/*
Process: com.example.myfirstkmmapp.android, PID: 2059
org.koin.core.error.InstanceCreationException:
Could not create instance for '[Factory:'com.example.myfirstkmmapp.sources.presentation.SourcesViewModel']'
 */
val sourcesModule = module{
    single<SourcesService> { SourcesService(get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesDataSource> { SourcesDataSource(get()) }
    single<SourcesRepository> { SourcesRepository(get(), get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
}