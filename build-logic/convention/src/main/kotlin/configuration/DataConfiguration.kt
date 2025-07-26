package configuration

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import utility.libs

internal fun Project.configureData() {
  extensions.configure<LibraryExtension> {
    namespace = "io.gitlab.ilyadreamix.nickel.data.$name"
  }

  dependencies {
    if (name != "common") {
      add("implementation", project(":data:common"))
    }

    add("implementation", project(":common"))

    add("implementation", libs.findLibrary("kotlin-serialization-json").get())

    add("implementation", libs.findLibrary("ktor-core").get())
    add("implementation", libs.findLibrary("ktor-cio").get())
    add("implementation", libs.findLibrary("ktor-contentNegotiation").get())
    add("implementation", libs.findLibrary("ktor-serialization-json").get())
  }
}
