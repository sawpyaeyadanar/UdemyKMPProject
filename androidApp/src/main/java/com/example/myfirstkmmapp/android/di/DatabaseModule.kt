package com.example.myfirstkmmapp.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.myfirstkmmapp.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import sevenpeaks.kmm.news.db.KMMDatabase

val databaseMode = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver()}
    single<KMMDatabase> { KMMDatabase(this.get())}
}