package com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nut.cdev.resistorcalculatorandroid.R
import com.nut.cdev.resistorcalculatorandroid.base.BaseActivity
import com.nut.cdev.resistorcalculatorandroid.databinding.ActivityFixedResistorBinding
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment.FixedIVResistorFragment
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment.FixedVIResistorFragment
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment.FixedVResistorFragment
import javax.inject.Inject

class FixedResistorActivity : BaseActivity<ActivityFixedResistorBinding, FixedResistorViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun getLayoutResId(): Int = R.layout.activity_fixed_resistor

    override fun createViewModel(savedInstanceState: Bundle?): FixedResistorViewModel {
        return ViewModelProvider(this, factory)[FixedResistorViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        loadFragment(FixedIVResistorFragment())
    }

    override fun initInstances() {
        binding.bnvFixedResistor.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.btnFixedIVBand -> {
                    loadFragment(FixedIVResistorFragment())
                    true
                }

                R.id.btnFixedVBand -> {
                    loadFragment(FixedVResistorFragment())
                    true
                }

                R.id.btnFixedVIBand -> {
                    loadFragment(FixedVIResistorFragment())
                    true
                }

//                R.id.home -> {
//                    loadFragment(HomeFragment())
//                    true
//                }
//                R.id.message -> {
//                    loadFragment(ChatFragment())
//                    true
//                }
//                R.id.settings -> {
//                    loadFragment(SettingFragment())
//                    true
//                }
                else -> {
                    loadFragment(FixedIVResistorFragment())
                    true
                }
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.resistorFragment, fragment)
        transaction.commit()
    }
}