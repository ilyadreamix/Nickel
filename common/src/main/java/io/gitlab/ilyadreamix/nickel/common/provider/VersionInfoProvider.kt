package io.gitlab.ilyadreamix.nickel.common.provider

data class VersionInfo(
    val name: String,
    val code: Int,
    val isDebuggable: Boolean
)

interface VersionInfoProvider {
    fun provide(): VersionInfo
}
