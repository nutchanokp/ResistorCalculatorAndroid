package com.nut.cdev.resistorcalculatorandroid.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.nut.cdev.resistorcalculatorandroid.R
import com.nut.cdev.resistorcalculatorandroid.base.BaseActivity
import com.nut.cdev.resistorcalculatorandroid.databinding.ActivityMainBinding
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.FixedResistorActivity
import com.nut.cdev.resistorcalculatorandroid.ui.smd_resistor.SmdResistorActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun createViewModel(savedInstanceState: Bundle?): MainViewModel {
        return ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initView() {
    }

    override fun initInstances() {

        binding.apply {
            btnFixedResistor.setOnClickListener {
                startActivity(Intent(this@MainActivity, FixedResistorActivity::class.java))
            }
            btnSMDResistor.setOnClickListener {
                startActivity(Intent(this@MainActivity, SmdResistorActivity::class.java))
            }

        }

    }
}