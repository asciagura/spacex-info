package io.rockets.android.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.rockets.android.R
import io.rockets.android.adapters.viewmodel.RocketLayoutViewModel
import io.rockets.android.data.Rocket
import io.rockets.android.databinding.RocketLayoutBinding

class RocketRecyclerViewAdapter : RecyclerView.Adapter<RocketRecyclerViewAdapter.RocketViewHolder>() {

    var items: MutableList<Rocket>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onHolderClick: ((RocketViewHolder) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder = RocketViewHolder(RocketLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = items?.size ?: 0

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        items?.get(position)
                ?.let {
                    holder.bindWith(it)
                }
    }


    inner class RocketViewHolder(val binding: RocketLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindWith(rocket: Rocket) {
            binding.viewModel = RocketLayoutViewModel(rocket)
                    .also {
                Glide.with(binding.rocketCoverView)
                        .load(it.cover)
                        //                        .apply(RequestOptions.placeholderOf(R.drawable.ic_rocket)
                        .apply(RequestOptions.centerCropTransform().fallback(R.drawable.ic_image_error).error(R.drawable.ic_image_error))
                        .into(binding.rocketCoverView)
            }
            binding.root.setOnClickListener {
                onHolderClick?.invoke(this)
            }
        }

        fun getItem(): Rocket? = binding.viewModel?.rocket

        val CARD_TRANSITION = "card_transition"
        val TITLE_TRANSITION = "title_tansition"
    }
}