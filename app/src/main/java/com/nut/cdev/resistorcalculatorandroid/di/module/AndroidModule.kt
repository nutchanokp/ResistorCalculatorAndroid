package com.nut.cdev.resistorcalculatorandroid.di.module

import android.app.Application
import android.content.Context
import android.view.inputmethod.InputMethodManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule {

//    @Singleton
//    @Provides
//    fun providePreferences(application: Application): SharedPreferences {
//        return application.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
//    }

    @Provides
    @Singleton
    fun provideInputMethodManager(application: Application): InputMethodManager {
        return application.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

//    @Provides
//    @Singleton
//    fun provideGoogleApiAvailability(): GoogleApiAvailability {
//        return GoogleApiAvailability.getInstance()
//    }
}
