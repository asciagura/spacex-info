package io.rockets.android.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractSectionableItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import io.rockets.android.R
import io.rockets.android.adapters.viewmodel.LaunchLayoutViewModel
import io.rockets.android.databinding.LaunchLayoutBinding

class LaunchItem(val launchViewModel: LaunchLayoutViewModel, yearHeaderItem: YearHeaderItem) : AbstractSectionableItem<LaunchItem.LaunchViewHolder, YearHeaderItem>(yearHeaderItem) {
    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?): LaunchViewHolder {
        return LaunchViewHolder(view!!, adapter!!)
    }

    override fun bindViewHolder(adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?, holder: LaunchViewHolder?, position: Int, payloads: MutableList<Any>?) {
        holder?.apply { binding.viewModel = launchViewModel }
    }

    override fun equals(other: Any?): Boolean {
        return if (other is LaunchItem)
            other.launchViewModel.launch.flightNumber == launchViewModel.launch.flightNumber
        else false
    }

    override fun getLayoutRes(): Int = R.layout.launch_layout

    inner class LaunchViewHolder(view: View, adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>) : FlexibleViewHolder(view, adapter) {
        val binding = LaunchLayoutBinding.bind(view)
    }
}