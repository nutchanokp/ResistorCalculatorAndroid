package com.nut.cdev.resistorcalculatorandroid.ui.splash_screen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.nut.cdev.resistorcalculatorandroid.R
import com.nut.cdev.resistorcalculatorandroid.base.BaseActivity
import com.nut.cdev.resistorcalculatorandroid.databinding.ActivitySplashScreenBinding
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.FixedResistorActivity
import javax.inject.Inject


@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding, SplashScreenViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    override fun getLayoutResId(): Int = R.layout.activity_splash_screen

    override fun createViewModel(savedInstanceState: Bundle?): SplashScreenViewModel {
        return ViewModelProvider(this, factory)[SplashScreenViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { true }
        Handler(Looper.getMainLooper()).postDelayed(
            {
                router.toFixedResistor()
                finish()
            }, 500
        )
    }

    override fun initView() {
    }

    override fun initInstances() {
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash_screen)
//
//
////        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
////        val configSettings = remoteConfigSettings {
////            minimumFetchIntervalInSeconds = 60
////        }
//////        val configSettings: FirebaseRemoteConfigSettings = FirebaseRemoteConfigSettings.Builder()
//////            .setDeveloperModeEnabled(BuildConfig.DEBUG)
//////            .build()
////        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
////        remoteConfig.setConfigSettingsAsync(configSettings)
////
////        remoteConfig.fetchAndActivate()
////            .addOnCompleteListener(this) { task ->
////                if (task.isSuccessful) {
////                    val updated = task.result
//////                    Log.d("TAG", "Config params updated: $updated")
//////                    Toast.makeText(
//////                        this, "Fetch and activate succeeded",
//////                        Toast.LENGTH_SHORT
//////                    ).show()
////                } else {
//////                    Toast.makeText(
//////                        this, "Fetch failed",
//////                        Toast.LENGTH_SHORT
//////                    ).show()
////                }
//////                displayWelcomeMessage()
////            }
////
//////        mFirebaseRemoteConfig.setConfigSettings(configSettings)
////
////        val s = remoteConfig.getLong("version")
////
////        if (s > BuildConfig.VERSION_CODE) {
////            Toast.makeText(this, "Update $s", Toast.LENGTH_LONG).show()
////            goToGoogleStore(this)
////        } else {
////            Toast.makeText(this, "Stable $s", Toast.LENGTH_LONG).show()
////            Handler().postDelayed({
////                startActivity(Intent(this, FixedResistorActivity::class.java))
////            }, 500)
////        }
//
//    }
}