import com.kotlin.aws.native.plugin.utils.runtime

plugins {
    kotlin("multiplatform") version "1.4.20-RC"
    id("io.kcdk.native") version "0.1.2" apply true
}

group = "io.kcdk.native.examples.hello-native"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx/")
    mavenLocal()
}

kotlin {
    linuxX64()
    sourceSets {
        val commonMain by getting {
            implementation("com.kotlin.aws:runtime-native:0.1.2")
        }
    }
}

runtime {
    handler = "helloWorldHandler"
}