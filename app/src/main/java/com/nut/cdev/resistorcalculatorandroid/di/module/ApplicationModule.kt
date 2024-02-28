package com.nut.cdev.resistorcalculatorandroid.di.module

import android.app.Application
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import com.nut.cdev.resistorcalculatorandroid.core.thread.CoroutinesThreadDispatcher
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class ApplicationModule {

    @Provides @Singleton fun providerPackageInfo(
        application: Application,
        packageManager: PackageManager
    ): PackageInfo {
        return packageManager.getPackageInfo(application.packageName, 0)
    }

    @Provides @Singleton fun providerPackageManager(application: Application): PackageManager {
        return application.packageManager
    }

    @Provides @Singleton fun provideCoroutinesDispatcher(): CoroutinesThreadDispatcher {
        return CoroutinesThreadDispatcher()
    }

    @Provides @Singleton
    fun provideContext(application: Application): Context = application

}
