package io.rockets.android.room

import android.app.Application
import androidx.room.Room

object DatabaseUtil {

    private var isInitialized = false

    @Synchronized
    fun init(application: Application) {
        if (!isInitialized)
            appDatabase = Room.databaseBuilder(application, AppDatabase::class.java, AppDatabase.dbName)
                    .build()
                    .also { isInitialized = true }
    }

    private lateinit var appDatabase: AppDatabase

    val rocketsDao by lazy { appDatabase.createRocketsDao() }

    val launchDao by lazy { appDatabase.createLaunchDao() }


}