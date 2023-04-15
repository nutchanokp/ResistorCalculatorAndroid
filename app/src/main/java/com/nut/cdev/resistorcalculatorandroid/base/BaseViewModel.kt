package com.nut.cdev.resistorcalculatorandroid.base

import android.content.Context
import androidx.lifecycle.ViewModel
import javax.inject.Inject

open class BaseViewModel @Inject constructor() : ViewModel() {

    lateinit var getContext: Context
}
