package com.nut.cdev.resistorcalculatorandroid.di.module

import com.nut.cdev.resistorcalculatorandroid.di.scope.PerFragment
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment.FixedIVResistorFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeFixedIVResistorFragment(): FixedIVResistorFragment


}

