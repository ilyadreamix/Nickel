import configuration.configureAndroidLibrary
import configuration.configureCompose
import configuration.configureKotlin
import configuration.configurePresentation
import org.gradle.api.Plugin
import org.gradle.api.Project

class PresentationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            configureAndroidLibrary()
            configureKotlin()
            configureCompose()
            configurePresentation()
        }
    }
}
