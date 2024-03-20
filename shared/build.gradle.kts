plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldetlight)
    id("co.touchlab.skie") version "0.6.0"
    kotlin("plugin.serialization") version "1.9.22"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            /*
            isStatic = true
            ld: Undefined symbols:
  _sqlite3_bind_blob, referenced from:
             */
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation("com.squareup.retrofit2:retrofit:2.9.0")
            implementation("io.ktor:ktor-client-core:2.0.3")
            implementation("com.squareup.sqldelight:runtime:1.5.3")
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
            implementation("org.jetbrains.kotlin:kotlin-stdlib-common:1.3.10")
            implementation ("io.ktor:ktor-client:1.0.0")
            implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.0.1")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlin.json)
            implementation(libs.kotlinx.datetime)
            implementation(libs.koin.core)
            implementation(libs.sqldelight.ext.flow)
            //put your multiplatform dependencies here
        }
        androidMain.dependencies {
            implementation("com.squareup.sqldelight:android-driver:1.5.3")
            implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.3.10")
//It is actual platform implementations
            implementation ("io.ktor:ktor-client-android:1.0.0")
            implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.1")
            implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
            implementation(libs.ktor.client.android)
            implementation(libs.sqldelight.driver.android)
        }
        iosMain.dependencies {
            //implementation("com.squareup.sqldelight:native-driver:1.5.3")
            implementation(libs.ktor.client.darwin)
            implementation(libs.sqldelight.driver.native)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)

        }
    }
}

android {
    namespace = "com.example.myfirstkmmapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

sqldelight {
    databases {
        create("KMMDatabase") {
            packageName.set("sevenpeaks.kmm.news.db")
        }
    }
}
