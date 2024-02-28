package com.nut.cdev.resistorcalculatorandroid.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nut.cdev.resistorcalculatorandroid.base.ViewModelFactory
import com.nut.cdev.resistorcalculatorandroid.di.ViewModelKey
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.FixedResistorViewModel
import com.nut.cdev.resistorcalculatorandroid.ui.main.MainViewModel
import com.nut.cdev.resistorcalculatorandroid.ui.splash_screen.SplashScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FixedResistorViewModel::class)
    abstract fun bindFixedResistorViewModel(viewModel: FixedResistorViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewModel::class)
    abstract fun bindSplashScreenViewModel(viewModel: SplashScreenViewModel): ViewModel

}
