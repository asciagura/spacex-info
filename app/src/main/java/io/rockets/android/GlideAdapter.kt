package io.rockets.android

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("glide_load")
fun loadImageFromUrl(imageView: ImageView, url: String? = null) {
    Glide.with(imageView)
            .load(url)
            .error(Glide.with(imageView).load(R.drawable.ic_image_error))
            .apply(RequestOptions.fitCenterTransform())
            .into(imageView)
}