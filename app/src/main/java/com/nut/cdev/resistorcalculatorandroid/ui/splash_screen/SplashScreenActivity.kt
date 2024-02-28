package com.nut.cdev.resistorcalculatorandroid.ui.splash_screen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.nut.cdev.resistorcalculatorandroid.BuildConfig
import com.nut.cdev.resistorcalculatorandroid.R
import com.nut.cdev.resistorcalculatorandroid.ext.goToGoogleStore
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.FixedResistorActivity


class SplashScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 60
        }
//        val configSettings: FirebaseRemoteConfigSettings = FirebaseRemoteConfigSettings.Builder()
//            .setDeveloperModeEnabled(BuildConfig.DEBUG)
//            .build()
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val updated = task.result
//                    Log.d("TAG", "Config params updated: $updated")
//                    Toast.makeText(
//                        this, "Fetch and activate succeeded",
//                        Toast.LENGTH_SHORT
//                    ).show()
                } else {
//                    Toast.makeText(
//                        this, "Fetch failed",
//                        Toast.LENGTH_SHORT
//                    ).show()
                }
//                displayWelcomeMessage()
            }

//        mFirebaseRemoteConfig.setConfigSettings(configSettings)

        val s = remoteConfig.getLong("version")

        if (s > BuildConfig.VERSION_CODE) {
            Toast.makeText(this, "Update $s", Toast.LENGTH_LONG).show()
            goToGoogleStore(this)
        } else {
            Toast.makeText(this, "Stable $s", Toast.LENGTH_LONG).show()
            Handler().postDelayed({
                startActivity(Intent(this, FixedResistorActivity::class.java))
            }, 500)
        }

    }
}