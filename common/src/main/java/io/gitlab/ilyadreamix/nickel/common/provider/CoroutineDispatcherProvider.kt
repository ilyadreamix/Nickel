package io.gitlab.ilyadreamix.nickel.common.provider

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
  fun provideDefault(): CoroutineDispatcher
  fun provideMain(): CoroutineDispatcher
  fun provideIO(): CoroutineDispatcher
}
