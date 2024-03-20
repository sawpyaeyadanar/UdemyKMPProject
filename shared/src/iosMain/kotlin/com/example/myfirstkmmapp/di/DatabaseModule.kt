package com.example.myfirstkmmapp.di

import app.cash.sqldelight.db.SqlDriver
import com.example.myfirstkmmapp.db.DatabaseDriverFactory
import org.koin.dsl.module
import sevenpeaks.kmm.news.db.KMMDatabase

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<KMMDatabase> { KMMDatabase(get())}
}