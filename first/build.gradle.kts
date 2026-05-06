plugins {
    alias(libs.plugins.jvm.library)
    alias(libs.plugins.maven.publish)
}

group = "ru.testmirrorartifacts"
version = "2026.05.00"

publishing {
    publications {
        create<MavenPublication>("release") {
            artifactId = "core"

            from(components["java"])
        }
    }
}
