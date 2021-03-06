package io.rockets.android.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtil {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    val rocketApi: RocketApi by lazy { retrofit.create(RocketApi::class.java) }

    val launchApi: LaunchApi by lazy { retrofit.create(LaunchApi::class.java) }
}