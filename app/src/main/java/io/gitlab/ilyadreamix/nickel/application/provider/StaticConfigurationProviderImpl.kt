package io.gitlab.ilyadreamix.nickel.application.provider

import android.content.Context
import io.gitlab.ilyadreamix.nickel.application.R
import io.gitlab.ilyadreamix.nickel.common.provider.StaticConfiguration
import io.gitlab.ilyadreamix.nickel.common.provider.StaticConfigurationProvider

internal class StaticConfigurationProviderImpl(private val applicationContext: Context)
    : StaticConfigurationProvider {

    override fun provide() = StaticConfiguration(
        cobaltServerUrl = applicationContext.getString(R.string.app_cobalt_server_url)
    )
}
