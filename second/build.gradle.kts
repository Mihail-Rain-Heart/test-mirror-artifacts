plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "ru.testmirrorartifacts.second"

    compileSdk = 36

    defaultConfig {
        minSdk = 21
    }

    publishing {
        singleVariant("release")
    }
}

dependencies {

    implementation(project(":first"))
}

group = "ru.testmirrorartifacts"
version = "2026.05.00"

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                artifactId = "util"

                from(components["release"])
            }
        }
    }
}
