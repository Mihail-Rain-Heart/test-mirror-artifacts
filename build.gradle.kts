import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.plugins.signing.SigningExtension

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose.compiler) apply false
    id("com.vanniktech.maven.publish") version "0.31.0" apply false
    id("org.jetbrains.dokka") version "1.9.20" apply false
}

val isCI = System.getenv("CI") == "true"

subprojects {

    plugins.withId("com.vanniktech.maven.publish") {

        extensions.configure<MavenPublishBaseExtension> {

            publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

            signAllPublications()

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
