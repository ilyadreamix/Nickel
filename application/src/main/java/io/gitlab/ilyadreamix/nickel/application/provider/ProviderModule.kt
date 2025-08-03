package io.gitlab.ilyadreamix.nickel.application.provider

import io.gitlab.ilyadreamix.nickel.common.provider.CoroutineDispatcherProvider
import io.gitlab.ilyadreamix.nickel.common.provider.StaticConfigurationProvider
import io.gitlab.ilyadreamix.nickel.common.provider.VersionInfoProvider
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val ProviderModule = module {
  singleOf(::DefaultVersionInfoProvider) { bind<VersionInfoProvider>() }
  singleOf(::DefaultCoroutineDispatcherProvider) { bind<CoroutineDispatcherProvider>() }
  singleOf(::DefaultStaticConfigurationProvider) { bind<StaticConfigurationProvider>() }
}
