package io.rockets.android.repository

import androidx.lifecycle.LiveData
import io.reactivex.disposables.Disposable
import io.rockets.android.data.Launch
import io.rockets.android.net.LaunchApi
import io.rockets.android.room.LaunchDao

class LaunchRepositoryImpl(private val launchApi: LaunchApi, private val launchDao: LaunchDao) : LaunchRepository {
    private var request: Disposable? = null

    override fun getRocketLaunches(rocketId: String, onFetchedCompleted: (() -> Unit)?): LiveData<List<Launch>> {
        if (request == null || request!!.isDisposed)
            request = launchApi.getAllRocketLaunches(rocketId)
                    .doFinally { onFetchedCompleted?.invoke() }
                    .subscribe({ list ->
                                   launchDao.insertAll(list.onEach { it.rocketId = rocketId })
                               },
                               { error -> })
        return launchDao.getRocketLaunches(rocketId)
    }
}