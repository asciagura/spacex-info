package io.rockets.android

import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.rockets.android.data.Rocket
import io.rockets.android.net.ApiUtil
import io.rockets.android.repository.RocketRepository
import io.rockets.android.repository.RocketRepositoryImpl
import io.rockets.android.room.DatabaseUtil

class RocketsListViewModel : ViewModel() {

    private val rocketDataSource: RocketRepository = RocketRepositoryImpl(ApiUtil.rocketApi, DatabaseUtil.rocketsDao)
    private var cached: List<Rocket>? = null

    val progressIndicatorVisibility = ObservableInt(View.GONE)

    val rockets: MutableLiveData<List<Rocket>> = MutableLiveData()

    val isActiveFiltered = MutableLiveData<Boolean>().apply { observeForever { value?.let { filterActiveStatus(it) } } }

    fun load(forceLoad: Boolean = false) {
        if (rockets.value == null || forceLoad) {
            progressIndicatorVisibility.set(View.VISIBLE)
            rocketDataSource.getAllRockets { progressIndicatorVisibility.set(View.GONE) }
                    .observeForever {
                        cached = it
                        filterActiveStatus(isActiveFiltered.value ?: false)
                    }
        }
        else {
            filterActiveStatus(isActiveFiltered.value ?: false)
        }
    }

    private fun filterActiveStatus(active: Boolean) {
        rockets.value = cached?.filter { if (active) it.active else true }
    }
}
