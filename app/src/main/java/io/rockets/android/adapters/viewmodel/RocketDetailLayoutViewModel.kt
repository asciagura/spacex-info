package io.rockets.android.adapters.viewmodel

import io.rockets.android.data.Rocket

class RocketDetailLayoutViewModel(val rocket: Rocket) {

    fun getName(): String = rocket.rocketName

    fun getDescription(): String = rocket.description

    fun getCompany(): String = rocket.company

    fun getCountry(): String = rocket.country
}