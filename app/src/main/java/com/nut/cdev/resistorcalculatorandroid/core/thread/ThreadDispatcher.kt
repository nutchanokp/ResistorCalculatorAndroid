package com.nut.cdev.resistorcalculatorandroid.core.thread

import kotlinx.coroutines.CoroutineDispatcher

interface ThreadDispatcher {
    fun ui(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
}
