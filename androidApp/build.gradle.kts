plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    //id("kotlin-kapt")
    //id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.myfirstkmmapp.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.myfirstkmmapp.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    implementation("io.coil-kt:coil-compose:2.5.0")  /// AsyncImage
    debugImplementation(libs.compose.ui.tooling)
    implementation("androidx.navigation:navigation-compose:2.7.5")
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    implementation(libs.accompanist.swiperefresh)
    //implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

    //implementation("com.google.dagger:hilt-android:2.42")
    //kapt("com.google.dagger:hilt-android-compiler:2.42")
    //kapt("androidx.hilt:hilt-compiler:1.0.0")
    //implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

}