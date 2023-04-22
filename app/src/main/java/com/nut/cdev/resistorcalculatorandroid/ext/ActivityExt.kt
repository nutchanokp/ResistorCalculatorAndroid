package com.nut.cdev.resistorcalculatorandroid.ext

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.nut.cdev.resistorcalculatorandroid.BuildConfig
import com.nut.cdev.resistorcalculatorandroid.R
import com.nut.cdev.resistorcalculatorandroid.ui.dialog.DialogAlertMessage


fun Activity.checkVersionApp(fragmentManager: FragmentManager) {

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

    val s = remoteConfig.getLong("version")

    if (s > BuildConfig.VERSION_CODE) {
//        Toast.makeText(this, "Update $s", Toast.LENGTH_LONG).show()
        this.showAlertDialog(fragmentManager, getString(R.string.new_version_update)) {
            goToGoogleStore(this)
        }
    } else {
//        Toast.makeText(context, "Stable $s", Toast.LENGTH_LONG).show()
//        Handler().postDelayed({
//            startActivity(Intent(context, FixedResistorActivity::class.java))
//        }, 500)
    }

}

fun Activity.showAlertDialog(
    fragmentManager: FragmentManager,
    message: String?,
    clickCallback: ((Unit) -> Unit)
) {
    message?.let {
        if (it.isEmpty()) return
        runOnUiThread {
            val dialog = DialogAlertMessage.newInstance(it)
            dialog.show(fragmentManager)
            dialog.setOnButtonLeftClick {
                clickCallback.invoke(Unit)
            }
        }
    }
}

