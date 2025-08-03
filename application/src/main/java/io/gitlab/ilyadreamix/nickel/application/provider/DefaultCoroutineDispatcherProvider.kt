package io.gitlab.ilyadreamix.nickel.application.provider

import io.gitlab.ilyadreamix.nickel.common.provider.CoroutineDispatcherProvider
import kotlinx.coroutines.Dispatchers

internal class DefaultCoroutineDispatcherProvider : CoroutineDispatcherProvider {
  override fun provideDefault() = Dispatchers.Default
  override fun provideMain() = Dispatchers.Main
  override fun provideIO() = Dispatchers.IO
}
