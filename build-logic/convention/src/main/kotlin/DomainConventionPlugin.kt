import configuration.configureAndroidLibrary
import configuration.configureDomain
import configuration.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project

class DomainConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
      }

      configureAndroidLibrary()
      configureKotlin()
      configureDomain()
    }
  }
}
