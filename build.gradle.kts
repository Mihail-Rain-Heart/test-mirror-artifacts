// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose.compiler) apply false
}

val isCI = System.getenv("CI") == "true"

subprojects {

    plugins.withId("maven-publish") {

        extensions.configure<PublishingExtension> {

            repositories {
                maven {
                    name = "mavenCentral"
                    url = uri("https://central.sonatype.com/api/v1/publisher")

                    credentials {
                        username = System.getenv("CENTRAL_USER")
                        password = System.getenv("CENTRAL_TOKEN")
                    }
                }
            }

            publications.withType(MavenPublication::class.java).configureEach {
                pom {
                    url.set("https://github.com/Mihail-Rain-Heart/test-mirror-artifacts")

                    licenses {
                        license {
                            name.set("MIT License")
                            url.set("https://opensource.org/licenses/MIT")
                        }
                    }

                    developers {
                        developer {
                            id.set("mihail")
                            name.set("Mihail")
                        }
                    }

                    scm {
                        url.set("https://github.com/Mihail-Rain-Heart/test-mirror-artifacts")
                    }
                }
            }
        }
    }

    plugins.withId("signing") {

        extensions.configure<SigningExtension> {

            if (isCI) {
                useInMemoryPgpKeys(
                    System.getenv("GPG_KEY"),
                    System.getenv("GPG_PASSWORD")
                )

                sign(extensions.getByType(PublishingExtension::class.java).publications)
            }
        }
    }
}
