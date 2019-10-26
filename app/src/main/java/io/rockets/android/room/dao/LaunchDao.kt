package io.rockets.android.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import io.rockets.android.data.Launch

@Dao
interface LaunchDao : BaseDao<Launch> {

    @Query("SELECT * FROM launches WHERE rocket_id=:rocketId")
    fun getRocketLaunches(rocketId: String): LiveData<List<Launch>>
}