package com.nut.cdev.resistorcalculatorandroid.di.activity

import androidx.appcompat.app.AppCompatActivity
import com.nut.cdev.resistorcalculatorandroid.di.module.ActivityModule
import com.nut.cdev.resistorcalculatorandroid.di.scope.PerActivity
import com.nut.cdev.resistorcalculatorandroid.ui.main.MainActivity
import com.nut.cdev.resistorcalculatorandroid.ui.splash_screen.SplashScreenActivity
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityModule::class])
abstract class SplashScreenActivityModule {

    @Binds
    @PerActivity
    abstract fun splashScreenActivityInjector(activity: SplashScreenActivity): AppCompatActivity
}
