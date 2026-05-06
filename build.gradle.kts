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

                mavenLocal()

                if (isCI) {
                    maven {
                        name = "TestGitHubPackages"
                        url =
                            uri("https://maven.pkg.github.com/Mihail-Rain-Heart/test-mirror-artifacts")

                        credentials {
                            username = System.getenv("GITHUB_USERNAME")
                            password = System.getenv("GITHUB_TOKEN")
                        }
                    }
                }
            }
        }
    }
}
