plugins {
    alias(libs.plugins.jvm.library)
    id("com.vanniktech.maven.publish")
    signing
}

group = "io.github.mihail-rain-heart"
version = "2026.05.00"

mavenPublishing {
    coordinates("io.github.mihail-rain-heart", "core", version.toString())

    pom {
        name.set("core")
        description.set("Core ...")
    }
}
