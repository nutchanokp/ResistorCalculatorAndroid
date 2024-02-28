package com.nut.cdev.resistorcalculatorandroid.di.module

import com.nut.cdev.resistorcalculatorandroid.di.scope.PerFragment
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment.FixedIVResistorFragment
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment.FixedVIResistorFragment
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment.FixedVResistorFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeFixedIVResistorFragment(): FixedIVResistorFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeFixedVResistorFragment(): FixedVResistorFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun contributeFixedVIResistorFragment(): FixedVIResistorFragment


}

