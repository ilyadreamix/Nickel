package configuration.helper

import com.android.build.api.dsl.VariantDimension
import java.util.Properties

internal fun VariantDimension.configureStaticConfiguration(localProperties: Properties) {
  val staticConfiguration = localProperties.getStaticConfiguration()
  val serverUrl = '"' + staticConfiguration.serverUrl + '"'
  val recaptchaKey = '"' + staticConfiguration.recaptchaKey + '"'

  buildConfigField("String", BuildConfigKeyServerUrl, serverUrl)
  buildConfigField("String", BuildConfigKeyRecaptchaKey, recaptchaKey)
}

private const val BuildConfigKeyServerUrl = "NICKEL_STATIC_CONFIGURATION_SERVER_URL"
private const val BuildConfigKeyRecaptchaKey = "NICKEL_STATIC_CONFIGURATION_RECAPTCHA_KEY"

private data class StaticConfiguration(
  val serverUrl: String,
  val recaptchaKey: String
)

private fun Properties.getStaticConfiguration(): StaticConfiguration {
  val serverUrl = getProperty(LocalPropertiesKeyServerUrl) ?: throw IllegalStateException()
  val recaptchaKey = getProperty(LocalPropertiesKeyRecaptchaKey) ?: throw IllegalStateException()
  return StaticConfiguration(serverUrl, recaptchaKey)
}

private const val LocalPropertiesKeyServerUrl = "nickel.static-configuration.server-url"
private const val LocalPropertiesKeyRecaptchaKey = "nickel.static-configuration.recaptcha-key"
