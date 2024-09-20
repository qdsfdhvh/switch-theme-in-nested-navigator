plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
}

android {
    namespace = "com.example.switch_theme_in_nested_navigator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.switch_theme_in_nested_navigator"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    // composeOptions {
    //     kotlinCompilerExtensionVersion = "1.5.1"
    // }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(compose.ui)
    implementation(compose.material3) // same with 1.2.1 🚫
    // implementation("androidx.compose.material3:material3:1.1.2") // ✅
    // implementation("androidx.compose.material3:material3:1.2.0") // 🚫
    // implementation("androidx.compose.material3:material3:1.2.1") // 🚫
    // implementation("androidx.compose.material3:material3:1.3.0") // 🚫

    implementation("cafe.adriel.voyager:voyager-navigator:1.1.0-beta02")


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}