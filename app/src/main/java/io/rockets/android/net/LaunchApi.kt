package io.rockets.android.net

import io.reactivex.Single
import io.rockets.android.data.Launch
import retrofit2.http.GET
import retrofit2.http.Query

interface LaunchApi {

    @GET("launches")
    fun getAllRocketLaunches(@Query("rocket_id") rocketId: String): Single<List<Launch>>
}