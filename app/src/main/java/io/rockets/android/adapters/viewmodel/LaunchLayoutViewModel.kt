package io.rockets.android.adapters.viewmodel

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import io.rockets.android.R
import io.rockets.android.data.Launch
import java.text.DateFormat
import java.util.*

class LaunchLayoutViewModel(val launch: Launch) {

    fun getMissionName(): String = launch.missionName

    fun getLaunchDate(): String = DateFormat.getDateInstance(DateFormat.MEDIUM).format(launch.launchDateUtc)

    @StringRes
    fun getSuccessText(): Int = if (launch.launchSuccess) R.string.success else R.string.failed

    fun getPatch(): String? = launch.links.missionPatch

    fun getSuccessVisibility(): Int = if (isLaunched()) View.VISIBLE else View.GONE

    @ColorRes
    fun getSuccessTextColor(): Int = if (isLaunched() && launch.launchSuccess) R.color.success_color else R.color.fail_color

    private fun isLaunched(): Boolean = launch.launchDateUtc?.before(Date()) == true
}