package io.rockets.android

import android.app.Application
import io.rockets.android.room.DatabaseUtil

class RocketApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DatabaseUtil.init(this)
    }
}