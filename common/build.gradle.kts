import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvm()
    js(IR) {
        browser {
            binaries.executable()
        }
        nodejs()
    }

    sourceSets {
        /* Main source sets */
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
//                implementation(libs.ktor.client.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.datetime)
            }
        }
        val jvmMain by getting {
            dependencies {
//                implementation(libs.ktor.client.jvm)
            }
        }
        val jsMain by getting {
            dependencies {
//                implementation(libs.ktor.client.js)
                implementation("org.jetbrains.kotlinx:kotlinx-html:0.10.1")
            }
        }

        /* Main hierarchy */
        jvmMain.dependsOn(commonMain)
        jsMain.dependsOn(commonMain)

        /* Test source sets */
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmTest by getting
        val jsTest by getting

        /* Test hierarchy */
        jvmTest.dependsOn(commonTest)
        jsTest.dependsOn(commonTest)
    }
}
