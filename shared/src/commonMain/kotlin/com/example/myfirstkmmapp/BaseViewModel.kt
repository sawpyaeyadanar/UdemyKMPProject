package com.example.myfirstkmmapp

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel {
    val scope: CoroutineScope
}