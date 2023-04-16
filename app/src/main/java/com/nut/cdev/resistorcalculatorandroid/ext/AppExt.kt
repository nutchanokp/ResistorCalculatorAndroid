package com.nut.cdev.resistorcalculatorandroid.ext

import android.content.Context
import android.content.Intent
import android.net.Uri


fun Any.goToGoogleStore(context: Context) {

//    val appPackageName = context.packageName
    val appPackageName = "com.nut.cdev.resistorcalculatorandroid"

    try {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("market://details?id=$appPackageName")
            )
        )
    } catch (anfe: android.content.ActivityNotFoundException) {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
            )
        )
    }
}