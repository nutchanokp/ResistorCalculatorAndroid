package com.nut.cdev.resistorcalculatorandroid.ui.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nut.cdev.resistorcalculatorandroid.R

class TestActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_activity2)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TestActivity2Fragment.newInstance())
                .commitNow()
        }
    }
}