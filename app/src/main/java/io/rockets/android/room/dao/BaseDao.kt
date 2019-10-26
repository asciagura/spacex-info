package io.rockets.android.room.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(instance: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(instances: List<T>): Array<Long>
}