package io.rockets.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration
import io.rockets.android.R
import io.rockets.android.RocketDetailViewModel
import io.rockets.android.adapters.LaunchItem
import io.rockets.android.adapters.LineGraphItem
import io.rockets.android.adapters.RocketDetailItem
import io.rockets.android.adapters.YearHeaderItem
import io.rockets.android.adapters.viewmodel.LaunchGraphViewModel
import io.rockets.android.adapters.viewmodel.LaunchLayoutViewModel
import io.rockets.android.adapters.viewmodel.RocketDetailLayoutViewModel
import io.rockets.android.adapters.viewmodel.YearHeaderLayoutViewModel
import io.rockets.android.databinding.RocketDetailFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*


class RocketDetailFragment : Fragment() {

    private val viewModel: RocketDetailViewModel by viewModel()
    private lateinit var binding: RocketDetailFragmentBinding
    private val adapter = FlexibleAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            RocketDetailFragmentArgs.fromBundle(it)
                .let { args ->
                    viewModel.setup(args.rocketId)
                    viewModel.launches.observe(this, { list ->
                        adapter.clear()
                        val items = list.flatMap { group ->
                            val yearViewHolder =
                                YearHeaderItem(YearHeaderLayoutViewModel(group.key ?: Date()))
                            group.value.map { launch ->
                                LaunchItem(LaunchLayoutViewModel(launch), yearViewHolder)
                            }
                        }
                        if (list.isNotEmpty())
                            adapter.addItem(0, LineGraphItem(LaunchGraphViewModel(list)))
                        viewModel.rocket.get()
                            ?.let { rocket ->
                                adapter.addItem(RocketDetailItem(RocketDetailLayoutViewModel(rocket)))
                            }

                        adapter.addItems(adapter.itemCount, items)
                        binding.swipeRefreshLayout.isRefreshing = false
                    })
                    viewModel.rocket.addOnPropertyChangedCallback(object :
                        Observable.OnPropertyChangedCallback() {
                        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                            activity?.let { activity ->
                                if (activity is AppCompatActivity)
                                    activity.supportActionBar?.title = viewModel.rocket.get()
                                        ?.rocketName
                            }
                            viewModel.rocket.get()
                                ?.let { rocket ->
                                    val item = RocketDetailItem(RocketDetailLayoutViewModel(rocket))
                                    if (adapter.contains(item))
                                        adapter.updateItem(item)
                                    else adapter.addItem(item)
                                }
                        }
                    })
                }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RocketDetailFragmentBinding.inflate(inflater, container, false)
            .apply {
                viewModel = this@RocketDetailFragment.viewModel
                swipeRefreshLayout.setOnRefreshListener {
                    this@RocketDetailFragment.viewModel.load(true)
                }
                adapter.apply {
                    setDisplayHeadersAtStartUp(true)
                    setStickyHeaders(true)
                }
                launchRecyclerview.addItemDecoration(
                    FlexibleItemDecoration(requireContext())
                        .addItemViewType(R.layout.year_header_layout, 8, 8, 8, 8) //values in dpi
                        .withEdge(true)
                )
                launchRecyclerview.addItemDecoration(
                    FlexibleItemDecoration(requireContext()).withDefaultDivider(
                        R.layout.launch_layout
                    )
                )
                launchRecyclerview.adapter = adapter
            }
        return binding.root
    }
}
