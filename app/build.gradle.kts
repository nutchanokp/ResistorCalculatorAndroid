plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")

}

android {
    namespace = "com.nut.cdev.resistorcalculatorandroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nut.cdev.resistorcalculatorandroid"
        minSdk = 24
        targetSdk = 34
        versionCode = 3
        versionName = "0.0.3"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            keyAlias = "resistorcalculator"
            keyPassword = "resistor42538601"
            storeFile = file("Z:/PROJECTS/keystore/ResistorCalculatorAndroid/keystore-resistorcalculator")
            storePassword = "resistor42538601"
        }
    }


    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    dataBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.core.ktx)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Multidex
    implementation(libs.androidx.multidex)
    // Dagger 2
    kapt(libs.dagger.compiler)
    kapt(libs.dagger.android.processor)
    implementation(libs.dagger.android.support)
    implementation(libs.dagger)

    kapt(libs.kotlinx.metadata.jvm)
    // RX
    implementation(libs.rxandroid)
    implementation(libs.rxjava)
    implementation(libs.rxkotlin)
    // ADS
    implementation(libs.play.services.ads)
    // GLIDE
    implementation(libs.glide)
    // Firebase
    //noinspection BomWithoutPlatform
    implementation(libs.firebase.bom)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.config)

    implementation(libs.android.loading.animation)

    implementation(libs.androidx.core.splashscreen)

    implementation(libs.lottie)

}

kapt {
    correctErrorTypes = true
    generateStubs = true
}