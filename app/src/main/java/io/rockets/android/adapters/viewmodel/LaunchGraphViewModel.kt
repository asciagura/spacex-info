package io.rockets.android.adapters.viewmodel

import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import io.rockets.android.data.Launch
import java.util.*

class LaunchGraphViewModel(items: Map<Date, List<Launch>>) {

    val series = items.map { group -> DataPoint(group.key, group.value.size.toDouble()) }

    fun getSeries(): LineGraphSeries<DataPoint> = LineGraphSeries(series.toTypedArray()).apply {
        setAnimated(true)
        isDrawDataPoints = true
    }
}