package io.rockets.android.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import io.rockets.android.R
import io.rockets.android.adapters.viewmodel.RocketDetailLayoutViewModel
import io.rockets.android.databinding.RocketDeatilLayoutBinding

class RocketDetailItem(val viewModel: RocketDetailLayoutViewModel) : AbstractFlexibleItem<RocketDetailItem.RocketDetailViewHolder>() {
    override fun bindViewHolder(adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?, holder: RocketDetailViewHolder?, position: Int, payloads: MutableList<Any>?) {
        holder?.binding?.apply { viewModel = this@RocketDetailItem.viewModel }
    }

    override fun equals(other: Any?): Boolean = other is RocketDetailItem

    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?): RocketDetailViewHolder = RocketDetailViewHolder(view, adapter)


    override fun getLayoutRes(): Int = R.layout.rocket_deatil_layout


    inner class RocketDetailViewHolder(view: View?, adapter: FlexibleAdapter<out IFlexible<*>>?) : FlexibleViewHolder(view, adapter, false) {
        val binding = view?.let { RocketDeatilLayoutBinding.bind(it) }
    }
}