val ktorVersion: String by project
val logbackVersion: String by project

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.0"
}

android {
    namespace = "com.example.car_sellingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.car_sellingapp"
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
                "proguard-rules.pro",
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    packaging {
        resources {
            excludes += "META-INF/INDEX.LIST"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom)) // BOM for Compose

    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4) // Only use ui-test-junit4

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.accompanist.navigation.animation)

    implementation(libs.lifecycle.runtime.ktx.v251)
    implementation(libs.lifecycle.viewmodel.compose)

    implementation(libs.ktor.client.content.negotiation)

    // new dependency

    implementation("io.ktor:ktor-client-core:3.0.1")
    implementation("io.ktor:ktor-client-android:3.0.1")
    implementation("io.ktor:ktor-client-serialization:3.0.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.0.1")
    implementation("io.ktor:ktor-client-logging:3.0.1")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")


    implementation("androidx.compose.ui:ui:1.7.6")

    implementation("androidx.activity:activity-ktx:1.7.2")

    implementation("io.coil-kt:coil-compose:2.2.0")


    // end new dependency
}
