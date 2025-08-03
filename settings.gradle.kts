@file:Suppress("UnstableApiUsage")

pluginManagement {

  includeBuild("build-logic")

  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "Nickel"

include(":application")
include(":common")

include(":presentation:common")
include(":presentation:root")

include(":data:common")

include(":domain:common")
