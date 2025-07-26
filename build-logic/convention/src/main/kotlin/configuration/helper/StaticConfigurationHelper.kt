package configuration.helper

import com.android.build.api.dsl.VariantDimension
import java.util.Properties

internal fun VariantDimension.configureStaticConfiguration(localProperties: Properties) {
  val staticConfiguration = localProperties.getStaticConfiguration()
  val serverUrl = '"' + staticConfiguration.serverUrl + '"'
  val recaptchaKey = '"' + staticConfiguration.recaptchaKey + '"'

  buildConfigField("String", BUILD_CONFIG_KEY_SERVER_URL, serverUrl)
  buildConfigField("String", BUILD_CONFIG_KEY_RECAPTCHA_KEY, recaptchaKey)
}

private const val BUILD_CONFIG_KEY_SERVER_URL = "NICKEL_STATIC_CONFIGURATION_SERVER_URL"
private const val BUILD_CONFIG_KEY_RECAPTCHA_KEY = "NICKEL_STATIC_CONFIGURATION_RECAPTCHA_KEY"

private data class StaticConfiguration(
  val serverUrl: String,
  val recaptchaKey: String
)

private fun Properties.getStaticConfiguration(): StaticConfiguration {
  val serverUrl = getProperty(PROPERTIES_KEY_SERVER_URL) ?: throw IllegalStateException()
  val recaptchaKey = getProperty(PROPERTIES_KEY_RECAPTCHA_KEY) ?: throw IllegalStateException()
  return StaticConfiguration(serverUrl, recaptchaKey)
}

private const val PROPERTIES_KEY_SERVER_URL = "nickel.static-configuration.server-url"
private const val PROPERTIES_KEY_RECAPTCHA_KEY = "nickel.static-configuration.recaptcha-key"
