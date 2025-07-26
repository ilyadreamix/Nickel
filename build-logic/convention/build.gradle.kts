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
      id = "io.gitlab.ilyadreamix.nickel.buildlogic.android.application"
      implementationClass = "AndroidApplicationConventionPlugin"
    }

    register("android-library") {
      id = "io.gitlab.ilyadreamix.nickel.buildlogic.android.library"
      implementationClass = "AndroidLibraryConventionPlugin"
    }

    register("presentation") {
      id = "io.gitlab.ilyadreamix.nickel.buildlogic.presentation"
      implementationClass = "PresentationConventionPlugin"
    }

    register("data") {
      id = "io.gitlab.ilyadreamix.nickel.buildlogic.data"
      implementationClass = "DataConventionPlugin"
    }

    register("domain") {
      id = "io.gitlab.ilyadreamix.nickel.buildlogic.domain"
      implementationClass = "DomainConventionPlugin"
    }
  }
}
