package com.nut.cdev.resistorcalculatorandroid.di.module

import android.app.Application
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import com.nut.cdev.resistorcalculatorandroid.core.thread.CoroutinesThreadDispatcher
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class ApplicationModule {

//    @Provides @Singleton fun provideToggle(): ToggleUtils = ToggleUtils()
//
//    @Provides @Singleton fun provideTungngernPreference(sharedPreferences: SharedPreferences): TungngernPreference {
//        return TungngernPreference(sharedPreferences)
//    }
//
//    @Provides @Singleton fun provideAnnouncementMapDialogWeeklyCheck(tungngernPreference: TungngernPreference): WeeklyCheck {
//        return AnnouncementMapDialogWeeklyCheck(tungngernPreference)
//    }
//
//    @Provides @Singleton fun providerWifiManager(application: Application): WifiManager =
//        application.getSystemService(Context.WIFI_SERVICE) as WifiManager
//
//    @Provides @Singleton fun providerVisionPresenter() =
//        VisionCheckerPresenter()
//
//    @Provides @Singleton fun providerVisionQrCheckerPresenter() =
//        VisionQrCheckerPresenter()

    @Provides @Singleton fun providerPackageInfo(
        application: Application,
        packageManager: PackageManager
    ): PackageInfo {
        return packageManager.getPackageInfo(application.packageName, 0)
    }

    @Provides @Singleton fun providerPackageManager(application: Application): PackageManager {
        return application.packageManager
    }

//    @Provides @Singleton fun providerBuildToggle(): AppBuildToggle {
//        return AppBuildToggle()
//    }
//
//    @Provides @Singleton fun provideAlipayWechatTimePeriod(): AlipayWechatTimePeriod {
//        return AlipayWechatTimePeriod()
//    }

    @Provides @Singleton fun provideCoroutinesDispatcher(): CoroutinesThreadDispatcher {
        return CoroutinesThreadDispatcher()
    }

//    @Provides @Singleton
//    fun provideAndroidCameraSupport(packageManager: PackageManager): AndroidCameraSupport {
//        return AndroidCameraSupport(packageManager)
//    }
//
//    @Provides @Singleton
//    fun provideAndroidFlashSupport(packageManager: PackageManager): AndroidFlashSupport {
//        return AndroidFlashSupport(packageManager)
//    }
//
//    @Provides @Singleton
//    fun provideHardwareSupport(cameraSupport: AndroidCameraSupport, flashSupport: AndroidFlashSupport)
//            = HardwareSupport(cameraSupport, flashSupport)

    @Provides @Singleton
    fun provideContext(application: Application): Context = application

//    @Provides @Singleton
//    fun provideChuckerCollector(context: Context): ChuckerCollector {
//        return ChuckerCollector(
//            context = context,
//            showNotification = true,
//            retentionPeriod = RetentionManager.Period.ONE_HOUR
//        )
//    }
}
