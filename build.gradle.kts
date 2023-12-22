// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
//    id ("com.android.library") version "8.1.1" apply false
    //firebase
    id("com.google.gms.google-services") version "4.4.0" apply false
//    id("org.jetbrains.kotlin.kapt") version "1.7.20-Beta"
//    id("com.google.devtools.ksp") version "1.8.0-1.0.8" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0-Beta2" apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
}

