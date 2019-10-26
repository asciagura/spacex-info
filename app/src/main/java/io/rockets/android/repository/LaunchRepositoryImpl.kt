package io.rockets.android.repository

import androidx.lifecycle.LiveData
import io.rockets.android.data.Launch
import io.rockets.android.net.LaunchApi
import io.rockets.android.room.dao.LaunchDao

class LaunchRepositoryImpl(private val launchApi: LaunchApi, private val launchDao: LaunchDao) :
    LaunchRepository {

    override suspend fun getRocketLaunches(
        rocketId: String,
        onFetchedCompleted: (() -> Unit)?
    ): LiveData<List<Launch>> {
        launchApi.getAllRocketLaunchesAsync(rocketId).run {
            launchDao.insertAll(this)
        }
        return launchDao.getRocketLaunches(rocketId)
    }
}