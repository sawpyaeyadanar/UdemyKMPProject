package com.example.myfirstkmmapp.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import sevenpeaks.kmm.news.db.KMMDatabase

actual class DatabaseDriverFactory() {
    actual fun createDriver(): SqlDriver = NativeSqliteDriver(schema = KMMDatabase.Schema, name = "KMMDatabase.db")
}