package io.rockets.android.adapters.viewmodel

import java.text.SimpleDateFormat
import java.util.*

class YearHeaderLayoutViewModel(private val year: Date) {
    private val dateFormat = SimpleDateFormat("yyyy", Locale.getDefault())
    fun getDate(): String = dateFormat.format(year)

    val id: Long = year.time
}