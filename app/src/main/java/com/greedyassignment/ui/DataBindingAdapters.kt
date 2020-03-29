package com.mpokket.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.imageloader.ImageLoader


@BindingAdapter("android:src")
fun setImageUrl(view: ImageView, url: String) {
    ImageLoader(view.context).displayImage(url, view)
}
