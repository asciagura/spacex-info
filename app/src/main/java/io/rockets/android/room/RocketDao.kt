package io.rockets.android.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import io.rockets.android.data.Rocket

@Dao
interface RocketDao : BaseDao<Rocket> {

    @Query("SELECT * FROM rockets")
    fun getAllRockets(): LiveData<List<Rocket>>

    @Query("SELECT * FROM rockets WHERE rocket_id=:rocketId")
    fun getRocketById(rocketId: String): LiveData<Rocket>
}
