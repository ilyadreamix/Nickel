package io.gitlab.ilyadreamix.nickel.common.provider

data class StaticConfiguration(val cobaltServerUrl: String)

interface StaticConfigurationProvider {
    fun provide(): StaticConfiguration
}
