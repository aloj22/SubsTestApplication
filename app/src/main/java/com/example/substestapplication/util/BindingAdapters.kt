package com.example.substestapplication.util


import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.substestapplication.BuildConfig
import java.text.DateFormat
import java.text.DecimalFormat
import java.util.*

object BindingAdaptersConstants {
    const val SIZE_BIG = "/w1280"
    const val SIZE_SMALL = "/w500"
}


@BindingAdapter(value = ["imageUrl"])
fun customImageUrl(imageView: ImageView, imageUrl: String?) {
    if (imageUrl?.isNotBlank() == true) {
        val sizeRoute = BindingAdaptersConstants.SIZE_BIG
        Glide.with(imageView.context).load("${BuildConfig.API_BASE_STATIC_URL}$sizeRoute$imageUrl").into(imageView)
    }
}

@BindingAdapter(value = ["smallImageUrl"])
fun customSmallImageUrl(imageView: ImageView, imageUrl: String?) {
    if (imageUrl?.isNotBlank() == true) {
        val sizeRoute = BindingAdaptersConstants.SIZE_SMALL
        Glide.with(imageView.context).load("${BuildConfig.API_BASE_STATIC_URL}$sizeRoute$imageUrl").into(imageView)
    }
}



@BindingAdapter(value = ["popularity"])
fun customPopularity(textView: TextView, popularity: Double) {
    textView.text = Math.round(popularity).toInt().toString()
}

@BindingAdapter(value = ["rating"])
fun customRating(textView: TextView, rating: Double) {
    textView.text = DecimalFormat("#.##").format(rating)
}

@BindingAdapter(value = ["date"])
fun customDate(textView: TextView, date: Date) {
    textView.text = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date)
}