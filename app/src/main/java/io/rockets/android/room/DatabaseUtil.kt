package io.rockets.android.room

import android.app.Application
import androidx.room.Room

object DatabaseUtil {

    @Synchronized
    fun init(application: Application) {
        if (!this::appDatabase.isInitialized)
            appDatabase = Room.databaseBuilder(application, AppDatabase::class.java, AppDatabase.dbName)
                .build()
    }

    private lateinit var appDatabase: AppDatabase

    val rocketsDao by lazy { appDatabase.createRocketsDao() }

    val launchDao by lazy { appDatabase.createLaunchDao() }


}