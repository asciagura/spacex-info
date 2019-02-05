package io.rockets.android.repository

import androidx.lifecycle.LiveData
import io.reactivex.disposables.Disposable
import io.rockets.android.data.Rocket
import io.rockets.android.net.RocketApi
import io.rockets.android.room.RocketDao

class RocketRepositoryImpl(private val rocketApi: RocketApi, private val rocketDao: RocketDao) : RocketRepository {

    private var request: Disposable? = null

    override fun getAllRockets(onFetchCompleted: (() -> Unit)?): LiveData<List<Rocket>> {
        if (request == null || request!!.isDisposed)
            request = rocketApi.getAll()
                    .doFinally { onFetchCompleted?.invoke() }
                    .subscribe({ list ->
                                   rocketDao.insertAll(list)
                               },
                               { error -> })
        return rocketDao.getAllRockets()
    }

    override fun getRocket(rocketId: String, onFetchCompleted: (() -> Unit)?): LiveData<Rocket> {
        if (request == null || request!!.isDisposed)
            request = rocketApi.getById(rocketId)
                    .doFinally { onFetchCompleted?.invoke() }
                    .subscribe({ rocket ->
                                   rocketDao.insert(rocket)

                               }, { error -> })
        return rocketDao.getRocketById(rocketId)
    }
}