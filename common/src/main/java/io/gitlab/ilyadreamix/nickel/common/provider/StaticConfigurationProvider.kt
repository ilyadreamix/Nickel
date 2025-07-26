package io.gitlab.ilyadreamix.nickel.common.provider

data class StaticConfiguration(
  val serverUrl: String,
  val recaptchaKey: String
)

interface StaticConfigurationProvider {
  fun provide(): StaticConfiguration
}
