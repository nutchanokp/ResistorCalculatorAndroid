package com.nut.cdev.resistorcalculatorandroid.base

import android.content.Context
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModel @Inject constructor() : ViewModel() {

    lateinit var getContext: Context
    private val disposeBag: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        this.disposeBag.clear()
    }

}
