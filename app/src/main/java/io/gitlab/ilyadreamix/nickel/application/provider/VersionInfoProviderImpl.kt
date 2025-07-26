package io.gitlab.ilyadreamix.nickel.application.provider

import io.gitlab.ilyadreamix.nickel.application.BuildConfig
import io.gitlab.ilyadreamix.nickel.common.provider.VersionInfo
import io.gitlab.ilyadreamix.nickel.common.provider.VersionInfoProvider

internal class VersionInfoProviderImpl : VersionInfoProvider {
  override fun provide() = VersionInfo(
    name = BuildConfig.VERSION_NAME,
    code = BuildConfig.VERSION_CODE,
    isDebuggable = BuildConfig.DEBUG
  )
}
