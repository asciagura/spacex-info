package io.rockets.android.di

import androidx.room.Room
import io.rockets.android.room.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, AppDatabase.dbName)
            .build()
    }

    factory { get<AppDatabase>().createLaunchDao() }
    factory { get<AppDatabase>().createRocketsDao() }
}