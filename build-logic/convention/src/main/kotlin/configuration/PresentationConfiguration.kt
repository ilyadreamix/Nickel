package configuration

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configurePresentation() {
    extensions.configure<LibraryExtension> {
        namespace = "io.gitlab.ilyadreamix.nickel.presentation.$name"
    }

    dependencies {
        if (name != "common") {
            add("implementation", project(":presentation:common"))
        }
    }
}
