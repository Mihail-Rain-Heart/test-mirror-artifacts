plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "ru.testmirrorartifacts"
    compileSdk = 36

    defaultConfig {
        applicationId = "ru.testmirrorartifacts"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug") // not metter because it is a demo. Need because benchmark runs on the release build.
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(project(":second"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.androidx.compose.material3)

    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.compose.view.model)

    // Coroutines
    implementation(libs.coroutines)
    implementation(libs.coroutines.guava)

    // Coil
    implementation(libs.bundles.coil)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}