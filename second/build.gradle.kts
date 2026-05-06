plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish)
    signing
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

group = "io.github.mihail-rain-heart"
version = "2026.05.00"

publishing {
    publications {
        create<MavenPublication>("release") {
            artifactId = "util"

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("util")
                description.set("Util module")
            }
        }
    }
}

dependencies {
    implementation(project(":first"))
}
