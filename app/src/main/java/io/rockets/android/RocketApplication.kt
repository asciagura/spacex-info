package io.rockets.android

import android.app.Application
import io.rockets.android.di.apiModule
import io.rockets.android.di.roomModule
import io.rockets.android.di.viewModelModule
import io.rockets.android.room.DatabaseUtil
import org.koin.core.context.startKoin

class RocketApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(roomModule, apiModule, viewModelModule)
        }
        DatabaseUtil.init(this)
    }
}