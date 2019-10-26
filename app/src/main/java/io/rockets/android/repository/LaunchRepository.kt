package io.rockets.android.repository

import androidx.lifecycle.LiveData
import io.rockets.android.data.Launch

interface LaunchRepository {
    suspend fun getRocketLaunches(rocketId: String, onFetchedCompleted: (() -> Unit)? = null): LiveData<List<Launch>>
}