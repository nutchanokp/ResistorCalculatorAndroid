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
        versionCode = 2
        versionName = "0.0.2"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    implementation("androidx.core:core-ktx:1.12.0")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Multidex
    implementation("androidx.multidex:multidex:2.0.1")
    // Dagger 2
    kapt("com.google.dagger:dagger-compiler:2.51")
    kapt("com.google.dagger:dagger-android-processor:2.51")
    implementation("com.google.dagger:dagger-android-support:2.51")
    implementation("com.google.dagger:dagger:2.51")

    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.9.0")
    // RX
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    // ADS
    implementation("com.google.android.gms:play-services-ads:22.6.0")
    // GLIDE
    implementation("com.github.bumptech.glide:glide:4.16.0")
    // Firebase
    //noinspection BomWithoutPlatform
    implementation( "com.google.firebase:firebase-bom:32.7.2")
    implementation("com.google.firebase:firebase-analytics:21.5.1")
    implementation("com.google.firebase:firebase-config:21.6.1")

    implementation("com.github.Marvel999:Android-Loading-Animation:1.0.0")

}

kapt {
    correctErrorTypes = true
    generateStubs = true
}