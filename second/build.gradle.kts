plugins {
    alias(libs.plugins.android.library)
    id("com.vanniktech.maven.publish")
    signing
}

android {
    namespace = "ru.testmirrorartifacts.second"
    compileSdk = 36

    defaultConfig {
        minSdk = 21
    }
}

group = "io.github.mihail-rain-heart"
version = "2026.05.00"

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
