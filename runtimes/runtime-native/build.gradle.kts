plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx/")
}

val ktorVersion = "1.4.2"
val datetimeVersion = "0.1.0"
// Could be either `cio` or `curl`.
// * `cio` has no external dependencies, as well as HTTPS.
// * `curl` supports HTTPS, but requires `libcurl.so.4`.
val ktorEngine = "curl"

kotlin {
    linuxX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$datetimeVersion")
            }
        }
        val linuxX64Main by getting {
            dependencies {
                implementation("io.ktor:ktor-client-$ktorEngine:$ktorVersion")
            }
        }
    }
}
