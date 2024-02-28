package com.nut.cdev.resistorcalculatorandroid.di.module

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.nut.cdev.resistorcalculatorandroid.core.router.MainRouter
import com.nut.cdev.resistorcalculatorandroid.di.scope.PerActivity
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {

    @Binds
    @PerActivity
    abstract fun activity(appCompatActivity: AppCompatActivity): Activity

    @Binds
    @PerActivity
    abstract fun activityContext(activity: Activity): Context

    @Module
    companion object {
        @Provides
        @JvmStatic
        @PerActivity
        fun provideRouter(activity: AppCompatActivity): MainRouter {
            return MainRouter(activity)
        }

    }
}
