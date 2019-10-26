package io.rockets.android.di

import io.rockets.android.net.LaunchApi
import io.rockets.android.net.RocketApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory { OkHttpClient.Builder().build() }

    single { get<Retrofit>().create(RocketApi::class.java) }

    single { get<Retrofit>().create(LaunchApi::class.java) }
}