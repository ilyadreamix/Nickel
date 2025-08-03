package io.gitlab.ilyadreamix.nickel.application.provider

import io.gitlab.ilyadreamix.nickel.application.BuildConfig
import io.gitlab.ilyadreamix.nickel.common.provider.StaticConfiguration
import io.gitlab.ilyadreamix.nickel.common.provider.StaticConfigurationProvider

internal class DefaultStaticConfigurationProvider : StaticConfigurationProvider {
  override fun provide() = StaticConfiguration(
    serverUrl = BuildConfig.NICKEL_STATIC_CONFIGURATION_SERVER_URL,
    recaptchaKey = BuildConfig.NICKEL_STATIC_CONFIGURATION_RECAPTCHA_KEY
  )
}
