plugins {
    alias(libs.plugins.jvm.library)
    alias(libs.plugins.maven.publish)
    signing
}

group = "io.github.mihail-rain-heart"
version = "2026.05.00"

publishing {
    publications {
        create<MavenPublication>("release") {
            artifactId = "core"

            from(components["java"])

            pom {
                name.set("core")
                description.set("Core module")
                url.set("https://github.com/Mihail-Rain-Heart/test-mirror-artifacts")
            }
        }
    }
}
