package io.rockets.android.adapters.viewmodel

import io.rockets.android.data.Rocket
import kotlin.random.Random

class RocketLayoutViewModel(val rocket: Rocket) {

    val name = rocket.rocketName

    val country = rocket.country

    val engineCount = rocket.engines.number

    val cover = rocket.flickrImages.getOrNull(Random(System.currentTimeMillis()).nextInt(0, rocket.flickrImages.size - 1))
}