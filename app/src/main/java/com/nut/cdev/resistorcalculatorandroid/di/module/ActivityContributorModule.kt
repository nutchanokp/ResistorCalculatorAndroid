package com.nut.cdev.resistorcalculatorandroid.di.module

import com.nut.cdev.resistorcalculatorandroid.di.activity.FixedResistorActivityModule
import com.nut.cdev.resistorcalculatorandroid.di.activity.MainActivityModule
import com.nut.cdev.resistorcalculatorandroid.di.scope.PerActivity
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.FixedResistorActivity
import com.nut.cdev.resistorcalculatorandroid.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributorModule {

//    @PerActivity
//    @ContributesAndroidInjector(modules = [SplashLoginActivityModule::class])
//    abstract fun bindSplashLoginActivity(): SplashLoginActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [FixedResistorActivityModule::class, FragmentBuildersModule::class])
    abstract fun bindFixedResistorActivity(): FixedResistorActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
//    @PerActivity
//    @ContributesAndroidInjector(modules = [BmiActivityModule::class])
//    abstract fun bindBmiActivity(): BMIActivity
//    @PerActivity
//    @ContributesAndroidInjector(modules = [BmrActivityModule::class])
//    abstract fun bindBmrActivity(): BMRActivity
}
