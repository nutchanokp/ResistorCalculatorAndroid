package com.nut.cdev.resistorcalculatorandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.nut.cdev.resistorcalculatorandroid.core.router.MainRouter
import com.nut.cdev.resistorcalculatorandroid.ext.checkVersionApp
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity<Binding : ViewDataBinding, VM : BaseViewModel> :
    AppCompatActivity(),
    CoroutineScope,
    HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    protected lateinit var binding: Binding
    protected lateinit var vm: VM

    lateinit var router : MainRouter

    override val coroutineContext: CoroutineContext get() = Job() + Dispatchers.Main

    protected abstract fun getLayoutResId(): Int
    abstract fun createViewModel(savedInstanceState: Bundle?): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutResId())
        binding.lifecycleOwner = this
        this.checkVersionApp(supportFragmentManager)
        router = MainRouter(this)
        vm = createViewModel(savedInstanceState)
        subscribeToViewModel(vm)

        initView()
        initInstances()
    }

    abstract fun initView()
    abstract fun initInstances()

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    protected fun subscribeToViewModel(viewModel: BaseViewModel) {
    }
}
