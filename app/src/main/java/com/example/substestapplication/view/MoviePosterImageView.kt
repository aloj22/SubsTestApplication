package com.example.substestapplication.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView



class MoviePosterImageView : AppCompatImageView {

    companion object {
        private const val ASPECT_RATIO = 1.5
    }

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        adjustViewBounds = true
        scaleType = ImageView.ScaleType.FIT_XY
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension((measuredHeight / ASPECT_RATIO).toInt(), measuredHeight)
    }

}