package com.nut.cdev.resistorcalculatorandroid.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModelMVVM @Inject constructor() : ViewModel() {

    private val disposeBag: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        this.disposeBag.clear()
    }
}
