package com.nut.cdev.resistorcalculatorandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.nut.cdev.resistorcalculatorandroid.Injectable
import dagger.android.support.AndroidSupportInjection

abstract class DataBindingFragment<Binding : ViewDataBinding, VM : BaseViewModel> :
    Fragment(), Injectable {
    private var _binding: Binding? = null

    protected val binding: Binding get() = _binding!!
    protected lateinit var vm: VM

    protected abstract fun getLayoutResId(): Int

    abstract fun createViewModel(savedInstanceState: Bundle?): VM

    protected abstract fun onCreateViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        setupInstance()
    }

    @Suppress("UNCHECKED_CAST")
    private fun setupInstance() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false) as Binding
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm = createViewModel(savedInstanceState)
        onCreateViewModel()

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}