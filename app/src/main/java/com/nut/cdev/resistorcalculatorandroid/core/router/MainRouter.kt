package com.nut.cdev.resistorcalculatorandroid.core.router

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.FixedResistorActivity
import javax.inject.Inject

class MainRouter @Inject constructor(
    val activity: AppCompatActivity
) {

    //    fun toMain() {
//        val intent = Intent(activity, MainActivity::class.java).apply {
//            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//        }
//
//        activity.apply {
//            startActivity(intent)
////            TransitionUtils().showActivityTransitionFromTop(activity)
//        }
//    }
//
    fun toFixedResistor() {
        val intent = Intent(activity, FixedResistorActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        activity.apply {
            startActivity(intent)
        }
    }
}
