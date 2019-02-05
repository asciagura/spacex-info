package io.rockets.android

import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("textColorRes")
fun textColorFromRes(view: TextView, @ColorRes colorRes: Int) {
    view.setTextColor(ResourcesCompat.getColor(view.resources, colorRes, null))
}