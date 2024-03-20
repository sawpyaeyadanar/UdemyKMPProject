package com.example.myfirstkmmapp.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import sevenpeaks.kmm.news.db.KMMDatabase

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver = AndroidSqliteDriver( schema = KMMDatabase.Schema, context = context, name = "KMM.Database.db")
}