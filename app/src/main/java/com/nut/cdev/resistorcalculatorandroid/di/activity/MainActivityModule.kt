package com.nut.cdev.resistorcalculatorandroid.di.activity

import androidx.appcompat.app.AppCompatActivity
import com.nut.cdev.resistorcalculatorandroid.di.module.ActivityModule
import com.nut.cdev.resistorcalculatorandroid.di.scope.PerActivity
import com.nut.cdev.resistorcalculatorandroid.ui.main.MainActivity
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityModule::class])
abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract fun mainActivityInjector(activity: MainActivity): AppCompatActivity
}
