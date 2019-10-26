package io.rockets.android.room

import android.app.Application
import androidx.room.Room
import io.rockets.android.room.dao.LaunchDao
import io.rockets.android.room.dao.RocketDao

object DatabaseUtil {

    @Synchronized
    fun init(application: Application) {
        if (!this::appDatabase.isInitialized)
            appDatabase =
                Room.databaseBuilder(application, AppDatabase::class.java, AppDatabase.dbName)
                    .build()
    }

    private lateinit var appDatabase: AppDatabase

    val rocketsDao: RocketDao
        get() = appDatabase.createRocketsDao()

    val launchDao: LaunchDao
        get() = appDatabase.createLaunchDao()

}