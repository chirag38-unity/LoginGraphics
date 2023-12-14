plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp") version ("1.9.0-1.0.13")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.chirag_redij.logingraphics"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.chirag_redij.logingraphics"
        minSdk = 29
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
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Splash Screen API
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Material Icons
    implementation("androidx.compose.material:material-icons-extended:1.5.4")

    // Compose Navigation UI
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")
    implementation("androidx.navigation:navigation-compose:2.7.5")

    // Compose - Destinations
    implementation("io.github.raamcosta.compose-destinations:animations-core:1.9.54")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.9.54")

    // Serialiser
    implementation("com.google.code.gson:gson:2.10")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")

    // Coil & Lottie
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation("com.google.accompanist:accompanist-coil:0.15.0")
    implementation("com.airbnb.android:lottie-compose:6.1.0")

}