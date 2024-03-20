package com.example.myfirstkmmapp

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

/*
class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

 */

actual class Platform() {
    actual val osName: String
        get() = "Android"
    actual val osVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val density: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo() {
        Log.d(
            "Daily Pulse",
            "($osName, $osVersion, $deviceModel, $density)"
        )
    }
}