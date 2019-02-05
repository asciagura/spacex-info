package io.rockets.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import io.rockets.android.RocketsListViewModel
import io.rockets.android.adapters.RocketRecyclerViewAdapter
import io.rockets.android.databinding.RocketsListFragmentBinding


class RocketsListFragment : Fragment() {

    private val viewModel: RocketsListViewModel by lazy {
        ViewModelProviders.of(this)
                .get(RocketsListViewModel::class.java)
    }
    private lateinit var binding: RocketsListFragmentBinding
    private val adapter = RocketRecyclerViewAdapter().apply {
        onHolderClick = this@RocketsListFragment::onRocketClicked
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.rockets.observe(this, Observer {
            adapter.items = it.toMutableList()
            binding.swipeRefreshLayout.isRefreshing = false
        })
    }

    override fun onResume() {
        super.onResume()
        binding.swipeRefreshLayout.isRefreshing = true
        viewModel.load()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = RocketsListFragmentBinding.inflate(inflater, container, false)
                .apply {
                    viewModel = this@RocketsListFragment.viewModel
                    rocketsRecyclerview.adapter = adapter
                    swipeRefreshLayout.setOnRefreshListener {
                        this@RocketsListFragment.viewModel.load(true)
                    }
                }
        return binding.root
    }

    private fun onRocketClicked(viewHolder: RocketRecyclerViewAdapter.RocketViewHolder) {
        viewHolder.getItem()
                ?.let {
                    ViewCompat.setTransitionName(viewHolder.binding.cardView, viewHolder.CARD_TRANSITION)
                    findNavController().navigate(RocketsListFragmentDirections.actionRocketsListFragmentToRocketDetailFragment(it.rocketId),
                                                 FragmentNavigator.Extras.Builder().addSharedElement(viewHolder.binding.root, viewHolder.CARD_TRANSITION).build())
                }
    }


}
