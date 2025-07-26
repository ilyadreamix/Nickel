import configuration.configureAndroidLibrary
import configuration.configureData
import configuration.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project

class DataConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
        apply("org.jetbrains.kotlin.plugin.serialization")
      }

      configureAndroidLibrary()
      configureKotlin()
      configureData()
    }
  }
}
