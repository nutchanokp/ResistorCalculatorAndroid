package com.nut.cdev.resistorcalculatorandroid.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nut.cdev.resistorcalculatorandroid.base.ViewModelFactory
import com.nut.cdev.resistorcalculatorandroid.di.ViewModelKey
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.FixedResistorViewModel
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment.FixedIVResistorFragmentViewModel
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment.FixedVIResistorFragmentViewModel
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment.FixedVResistorFragmentViewModel
import com.nut.cdev.resistorcalculatorandroid.ui.main.MainViewModel
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
    @ViewModelKey(FixedIVResistorFragmentViewModel::class)
    abstract fun bindFixedIVResistorFragmentViewModel(viewModel: FixedIVResistorFragmentViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(FixedVResistorFragmentViewModel::class)
    abstract fun bindFixedVResistorFragmentViewModel(viewModel: FixedVResistorFragmentViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(FixedVIResistorFragmentViewModel::class)
    abstract fun bindFixedVIResistorFragmentViewModel(viewModel: FixedVIResistorFragmentViewModel): ViewModel

}
