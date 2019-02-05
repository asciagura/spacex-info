package io.rockets.android.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractHeaderItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.flexibleadapter.items.IHolder
import eu.davidea.viewholders.FlexibleViewHolder
import io.rockets.android.R
import io.rockets.android.adapters.viewmodel.YearHeaderLayoutViewModel
import io.rockets.android.databinding.YearHeaderLayoutBinding


class YearHeaderItem(val viewModel: YearHeaderLayoutViewModel) : AbstractHeaderItem<YearHeaderItem.HeaderViewHolder>(), IHolder<YearHeaderLayoutViewModel> {
    override fun getModel(): YearHeaderLayoutViewModel = viewModel

    override fun bindViewHolder(adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?, holder: HeaderViewHolder?, position: Int, payloads: MutableList<Any>?) {
        holder?.apply {
            binding.viewModel = viewModel
        }
    }

    override fun equals(other: Any?): Boolean {
        return if (other is YearHeaderItem)
            other.viewModel.id == viewModel.id
        else false
    }

    override fun createViewHolder(view: View?, adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>?): HeaderViewHolder {
        return HeaderViewHolder(view!!, adapter!!)
    }

    override fun getLayoutRes(): Int = R.layout.year_header_layout

    inner class HeaderViewHolder(view: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(view, adapter, true) {

        val binding: YearHeaderLayoutBinding = YearHeaderLayoutBinding.bind(view)

    }
}