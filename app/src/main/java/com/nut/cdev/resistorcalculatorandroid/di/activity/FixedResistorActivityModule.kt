package com.nut.cdev.resistorcalculatorandroid.di.activity

import androidx.appcompat.app.AppCompatActivity
import com.nut.cdev.resistorcalculatorandroid.di.module.ActivityModule
import com.nut.cdev.resistorcalculatorandroid.di.scope.PerActivity
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.FixedResistorActivity
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityModule::class])
abstract class FixedResistorActivityModule {

    @Binds
    @PerActivity
    abstract fun fixedResistorActivityInjector(activity: FixedResistorActivity): AppCompatActivity
}
