package com.nut.cdev.resistorcalculatorandroid.di

import android.app.Application
import com.nut.cdev.resistorcalculatorandroid.di.module.ActivityContributorModule
import com.nut.cdev.resistorcalculatorandroid.di.module.AndroidModule
import com.nut.cdev.resistorcalculatorandroid.di.module.ApplicationModule
import com.nut.cdev.resistorcalculatorandroid.di.module.ViewModelModule
import com.nut.cdev.resistorcalculatorandroid.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidModule::class,
        ActivityContributorModule::class,
        ApplicationModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: MainApplication)
}
