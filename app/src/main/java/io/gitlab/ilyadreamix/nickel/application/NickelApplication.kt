package io.gitlab.ilyadreamix.nickel.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

internal class NickelApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    setupKoin()
  }

  private fun setupKoin() {
    startKoin {
      androidLogger(level = Level.DEBUG)
      androidContext(this@NickelApplication)
      modules(ApplicationModule)
    }
  }
}
