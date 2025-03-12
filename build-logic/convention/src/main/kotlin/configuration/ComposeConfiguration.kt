package configuration

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import utility.libs

internal fun Project.configureCompose() {
    extensions.configure<LibraryExtension> {
        buildFeatures {
            compose = true
        }
    }

    dependencies {
        add("implementation", libs.findLibrary("androidx-activity-compose").get())
        add("implementation", libs.findLibrary("androidx-compose-foundation").get())
        add("implementation", libs.findLibrary("androidx-compose-material-icons").get())
        add("debugImplementation", libs.findLibrary("androidx-compose-ui-tooling").get())
        add("implementation", libs.findLibrary("androidx-compose-ui-tooling-preview").get())
    }
}
