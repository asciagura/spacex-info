package io.rockets.android.di

import io.rockets.android.RocketDetailViewModel
import io.rockets.android.adapters.RocketDetailItem
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RocketDetailViewModel() }

}