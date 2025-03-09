import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.dsl)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    compileOnly(libs.android.gradle)
    compileOnly(libs.kotlin.gradle)
}

gradlePlugin {
    plugins {
        register("android-application") {
            id = "io.gitlab.ilyadreamix.nickel.buildlogic.androidapplication"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}
