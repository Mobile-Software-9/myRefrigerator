plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services") //firebase
//    id("com.google.devtools.ksp")
//    id ("org.jetbrains.kotlin.kapt")

}

android {
    namespace = "com.example.refrigerator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.refrigerator"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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
    compileOptions {  //17로 수정
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
        dataBinding = true
    }
//    kapt {
//        correctErrorTypes = true
//    }
}

dependencies {
    //google
    implementation ("com.google.android.gms:play-services-auth:20.7.0")
    implementation ("com.google.code.gson:gson:2.8.6")
    //firebase
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")

    // room
//    implementation ("androidx.room:room-runtime:2.5.1")
//    kapt("androidx.room:room-compiler:2.5.1")
//    implementation ("androidx.room:room-ktx:2.5.1")
//    kapt ("androidx.annotation:annotation:1.0.0")
//    kapt("org.xerial:sqlite-jdbc:3.44.1.0")
//    implementation ("org.slf4j:slf4j-simple:1.7.32")
//    // Coroutine
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth-ktx:22.3.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}