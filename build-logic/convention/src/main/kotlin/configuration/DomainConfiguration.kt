package configuration

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureDomain() {
  extensions.configure<LibraryExtension> {
    namespace = "io.gitlab.ilyadreamix.nickel.domain.$name"
  }

  dependencies {
    if (name != "common") {
      add("implementation", project(":domain:common"))
    }
  }
}
