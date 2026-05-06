plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "ru.testmirrorartifacts.second"

    compileSdk = 36

    defaultConfig {
        minSdk = 21
    }
}

dependencies {

    implementation(project(":first"))
}
