package io.rockets.android.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import io.rockets.android.R
import io.rockets.android.adapters.viewmodel.LaunchGraphViewModel
import io.rockets.android.databinding.LaunchGraphLayoutBinding
import java.text.SimpleDateFormat
import java.util.*

class LineGraphItem(val viewModel: LaunchGraphViewModel) : AbstractFlexibleItem<LineGraphItem.LineGraphViewHolder>() {
    override fun bindViewHolder(
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?,
            holder: LineGraphViewHolder?,
            position: Int,
            payloads: MutableList<Any>?
    ) {
        holder?.binding?.apply {
            graphView.apply {
                val series = viewModel.getSeries()
                removeAllSeries()
                addSeries(series)
                gridLabelRenderer.apply {
                    labelFormatter = DateAsXAxisLabelFormatter(context, SimpleDateFormat("yyyy", Locale.getDefault()))
                    setHumanRounding(true)
                    setHorizontalLabelsAngle(30)
                }
                viewport.apply {
                    isXAxisBoundsManual = true
                    if (viewModel.series.isNotEmpty()) {
                        setMaxX(viewModel.series[viewModel.series.size - 1].x)
                        setMinX(viewModel.series[0].x)
                    }
                }
                title = context.getString(R.string.launches_graph_title)
            }
        }
    }

    override fun equals(other: Any?): Boolean = other is LineGraphItem

    override fun createViewHolder(
            view: View?,
            adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?
    ): LineGraphViewHolder = LineGraphViewHolder(view, adapter)


    override fun getLayoutRes(): Int = R.layout.launch_graph_layout

    inner class LineGraphViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?) :
            FlexibleViewHolder(view, adapter, false) {
        val binding = view?.let { LaunchGraphLayoutBinding.bind(it) }
    }
}