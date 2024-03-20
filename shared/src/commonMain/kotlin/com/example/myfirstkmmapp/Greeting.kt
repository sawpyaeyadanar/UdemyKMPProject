package com.example.myfirstkmmapp

import io.ktor.client.*
import io.ktor.client.request.get
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.todayAt
import io.ktor.client.request.*
import io.ktor.client.statement.*

class Greeting {


    fun greet(): String {
        return "Hello" +
                "There are only ${daysUntilNewYear()} days left!"
    }
}

class WeatherAPI() {
    private val client = HttpClient()
    suspend fun fetchWeather(): String {
     return   client.get("\"$baseUrl/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").toString()
//        return client.get<String> {
//            url("$baseUrl/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
//        }
    }

    companion object {
        private const val baseUrl = "https://samples.openweathermap.org"
    }
}

fun daysUntilNewYear(): Int {
    val today = Clock.System.todayAt(TimeZone.currentSystemDefault())
    val closestNewYear = LocalDate(today.year + 1,11, 1)
    return today.daysUntil(closestNewYear)
}