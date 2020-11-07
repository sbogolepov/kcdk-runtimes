rootProject.name = "kotlin-aws-lambda-custom-runtimes"

pluginManagement {

    repositories {
        jcenter()
        mavenCentral()
        gradlePluginPortal()
    }

    val kotlinVersion: String by settings
    plugins {
        kotlin("jvm")  version kotlinVersion
        kotlin("multiplatform") version kotlinVersion
        kotlin("js") apply false version kotlinVersion
    }

}

include(":runtimes:runtime-graalvm")
include(":runtimes:runtime-native")
include(":runtimes:runtime-js")

include(":plugins:plugin-graalvm")
include(":plugins:plugin-js")
include(":plugins:plugin-native")
