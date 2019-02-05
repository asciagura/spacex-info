package io.rockets.android.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.rockets.android.data.Launch
import io.rockets.android.data.Rocket

@Database(entities = [Rocket::class, Launch::class], version = 1)
@TypeConverters(DateConverter::class, ArrayStringConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun createRocketsDao(): RocketDao

    abstract fun createLaunchDao(): LaunchDao

    companion object {
        const val dbName = "database.db"
    }
}