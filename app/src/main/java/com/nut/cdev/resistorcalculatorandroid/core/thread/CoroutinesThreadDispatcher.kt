package com.nut.cdev.resistorcalculatorandroid.core.thread

import kotlinx.coroutines.Dispatchers

class CoroutinesThreadDispatcher : ThreadDispatcher {

    override fun ui() = Dispatchers.Main

    override fun io() = Dispatchers.IO
}
