
//plugins {
//    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
//}

rootProject.name = "demo-kotlin-multiplatform"

include("fake-data-server")
include(":common")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("jvm").version("1.8.22")
        kotlin("multiplatform").version("1.8.22")
        kotlin("plugin.serialization").version("1.8.22")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            library("kotlinx-coroutines-core", "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
            library("ktor-client-core", "io.ktor:ktor-client-core:2.2.4")
            library("kotlinx-serialization-json", "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
            library("kotlinx-datetime", "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
            library("ktor-client-js", "io.ktor:ktor-client-js:2.2.4")
            library("ktor-client-jvm", "io.ktor:ktor-client-jvm:2.2.4")
        }
    }
}
