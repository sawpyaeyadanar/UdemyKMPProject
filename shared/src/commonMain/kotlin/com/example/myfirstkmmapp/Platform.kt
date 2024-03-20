package com.example.myfirstkmmapp
/*
interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
 */

expect class Platform  {
    val osName: String
    val osVersion: String
    val deviceModel: String
    val density: Int

    fun logSystemInfo()
}