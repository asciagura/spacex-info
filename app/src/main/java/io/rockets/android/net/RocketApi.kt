package io.rockets.android.net

import io.reactivex.Single
import io.rockets.android.data.Rocket
import retrofit2.http.GET
import retrofit2.http.Path

interface RocketApi {

    @GET("rockets")
    fun getAll(): Single<List<Rocket>>

    @GET("rockets")
    suspend fun getAllAsync(): List<Rocket>

    @GET("rockets/{rocketId}")
    fun getById(@Path("rocketId") rocketId: String): Single<Rocket>

    @GET("rockets/{rocketId}")
    suspend fun getByIdAsync(@Path("rocketId") rocketId: String): Rocket
}