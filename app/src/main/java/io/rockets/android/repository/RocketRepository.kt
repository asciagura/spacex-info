package io.rockets.android.repository

import androidx.lifecycle.LiveData
import io.rockets.android.data.Rocket

interface RocketRepository {
    fun getAllRockets(onFetchCompleted: (() -> Unit)? = null): LiveData<List<Rocket>>

    fun getRocket(rocketId: String, onFetchCompleted: (() -> Unit)? = null): LiveData<Rocket>
}