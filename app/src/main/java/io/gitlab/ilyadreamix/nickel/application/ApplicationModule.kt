package io.gitlab.ilyadreamix.nickel.application

import io.gitlab.ilyadreamix.nickel.application.provider.ProviderModule
import org.koin.dsl.module

internal val ApplicationModule = module {
    includes(ProviderModule)
}
