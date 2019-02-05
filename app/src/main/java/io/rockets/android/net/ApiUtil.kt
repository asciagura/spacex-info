package io.rockets.android.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtil {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.spacexdata.com/v3/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        .client(
            OkHttpClient.Builder()
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val rocketApi: RocketApi by lazy { retrofit.create(RocketApi::class.java) }

    val launchApi: LaunchApi by lazy { retrofit.create(LaunchApi::class.java) }
}