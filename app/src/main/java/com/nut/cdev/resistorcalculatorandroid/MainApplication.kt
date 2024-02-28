package com.nut.cdev.resistorcalculatorandroid

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.nut.cdev.resistorcalculatorandroid.di.DaggerAppComponent
import com.nut.cdev.resistorcalculatorandroid.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainApplication : MultiDexApplication(), HasAndroidInjector {

    @Inject
    lateinit var dispatchAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var application: Application
    protected lateinit var appComponent: AppComponent

    override fun androidInjector(): AndroidInjector<Any> = dispatchAndroidInjector

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
        AppInjector.init(this)
    }
}
