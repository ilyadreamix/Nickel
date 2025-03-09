package configuration

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.api.BaseVariantOutputImpl
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import utility.libs
import java.util.Properties

internal fun Project.configureAndroidApplication() {
    val localProperties = Properties()
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localProperties.load(localPropertiesFile.inputStream())
    }

    extensions.configure<ApplicationExtension> {

        configureAndroidCommon(this)

        namespace = "io.gitlab.ilyadreamix.nickel.application"

        defaultConfig {
            applicationId = "io.gitlab.ilyadreamix.nickel"
            targetSdk = libs.findVersion("nickel-sdk-target").get().toString().toInt()
            versionCode = libs.findVersion("nickel-version-code").get().toString().toInt()
            versionName = libs.findVersion("nickel-version-name").get().toString()
        }

        signingConfigs {
            create("release") {
                storeFile = file(localProperties.getProperty("nickel.signing.release.key.path"))
                storePassword = localProperties.getProperty("nickel.signing.release.key.password")
                keyAlias = localProperties.getProperty("nickel.signing.release.key.alias")
                keyPassword = localProperties.getProperty("nickel.signing.release.key.password")
            }
        }

        buildTypes {
            release {
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
                signingConfig = signingConfigs.getByName("release")
            }
        }
    }

    extensions.configure<AppExtension> {
        applicationVariants.all {
            outputs
                .map { output -> output as BaseVariantOutputImpl }
                .forEach { output ->
                    val name = "v${versionName}-b${versionCode}.apk"
                    output.outputFileName = name
                }
        }
    }
}

internal fun Project.configureAndroidLibrary() {
    extensions.configure<LibraryExtension> {
        configureAndroidCommon(this)
    }
}

private fun Project.configureAndroidCommon(extension: CommonExtension<*, *, *, *, *, *>) {
    with(extension) {

        compileSdk = libs.findVersion("nickel-sdk-compile").get().toString().toInt()

        defaultConfig {
            minSdk = libs.findVersion("nickel-sdk-minimum").get().toString().toInt()
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
            isCoreLibraryDesugaringEnabled = true
        }
    }

    dependencies {
        add("coreLibraryDesugaring", libs.findLibrary("android-desugar").get())
    }
}
