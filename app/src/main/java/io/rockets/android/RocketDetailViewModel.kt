package io.rockets.android

import android.view.View
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.rockets.android.data.Launch
import io.rockets.android.data.Rocket
import io.rockets.android.net.ApiUtil
import io.rockets.android.repository.LaunchRepository
import io.rockets.android.repository.LaunchRepositoryImpl
import io.rockets.android.repository.RocketRepository
import io.rockets.android.repository.RocketRepositoryImpl
import io.rockets.android.room.DatabaseUtil
import java.text.SimpleDateFormat
import java.util.*

class RocketDetailViewModel : ViewModel() {
    private val launchesRepository: LaunchRepository = LaunchRepositoryImpl(ApiUtil.launchApi, DatabaseUtil.launchDao)
    private val rocketRepository: RocketRepository = RocketRepositoryImpl(ApiUtil.rocketApi, DatabaseUtil.rocketsDao)
    lateinit var rocketId: String

    val rocket = ObservableField<Rocket>()
    val loadingIndicatorVisibility = ObservableInt(View.GONE)
    val launches = MutableLiveData<Map<Date, List<Launch>>>()

    private var launchesCached: Map<Date, List<Launch>>? = null

    fun setup(rocketId: String) {
        this.rocketId = rocketId
        loadingIndicatorVisibility.set(View.VISIBLE)
        rocketRepository.getRocket(rocketId) { }
                .observeForever {
                    rocket.set(it)
                }
        load()
    }

    fun load(forceLoad: Boolean = false) {
        loadingIndicatorVisibility.set(View.VISIBLE)
        if (launchesCached == null || forceLoad)
            launchesRepository.getRocketLaunches(rocketId) { loadingIndicatorVisibility.set(View.GONE) }
                    .observeForever { list ->
                        launchesCached = groupAndSort(list).also {
                            launches.value = it
                        }
                    }
        else
            launches.value = launchesCached
    }

    private fun groupAndSort(list: List<Launch>?): Map<Date, List<Launch>>? {
        val dateFormat = SimpleDateFormat("yyyy", Locale.getDefault())
        return list?.sortedBy { launch -> launch.launchDateUtc }
                ?.groupBy { launch ->
                    dateFormat.parse(launch.launchYear)
                }
    }

}
