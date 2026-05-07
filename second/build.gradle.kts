plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.vanniktech)
    signing
}

android {
    namespace = "ru.testmirrorartifacts.second"
    compileSdk = 36

    defaultConfig {
        minSdk = 21

        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
        }

        ndk {
            abiFilters += setOf(
                "arm64-v8a",
                "armeabi-v7a",
                "x86_64",
                "x86"
            )
        }
    }

    ndkVersion = "30.0.14904198"

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }
}

group = "io.github.mihail-rain-heart"
version = "2026.05.01"

mavenPublishing {
    coordinates("io.github.mihail-rain-heart", "util", version.toString())

    pom {
        name.set("util")
        description.set("Util ...")
    }
}

dependencies {
    implementation(project(":first"))
}
