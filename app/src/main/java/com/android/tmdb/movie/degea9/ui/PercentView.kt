package com.android.tmdb.movie.degea9.ui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.DecelerateInterpolator


class PercentView(context: Context, attrs: AttributeSet) : View(context, attrs) {


    val bgPaint = Paint()
    val trackPaint = Paint()
    val spinningPaint = Paint()
    val textPaint = TextPaint()
    var textHight: Float = 0f
    var sweepAngle = 0f;
    var percentText: String = ""
    var percent: Float = 0f
        set(value) {
            field = value
            percentText = value.toString()
            setup()
            animatePercent()
        }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //Log.e("PercentView", "widthMeasureSpec " + widthMeasureSpec + " heightMeasureSpec " + heightMeasureSpec)
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)
        val widthMode = View.MeasureSpec.getMode(widthMeasureSpec)
        val hightMode = View.MeasureSpec.getMode(heightMeasureSpec)
//        Log.e(
//            "PercentView",
//            "width " + width + " widthMode " + widthMode + " hightMode " + hightMode + " height " + height
//        )
//        if (widthMode == MeasureSpec.EXACTLY) {
//            Log.e("PercentView", "widthMode EXACTLY");
//        } else if (widthMode == MeasureSpec.AT_MOST) {
//            Log.e("PercentView", "widthMode AT_MOST");
//        } else if (widthMode == MeasureSpec.UNSPECIFIED) {
//            Log.e("PercentView", "widthMode UNSPECIFIED");
//        }
//
//        if (hightMode == MeasureSpec.EXACTLY) {
//            Log.e("PercentView", "hightMode EXACTLY");
//        } else if (hightMode == MeasureSpec.AT_MOST) {
//            Log.e("PercentView", "hightMode AT_MOST");
//        } else if (hightMode == MeasureSpec.UNSPECIFIED) {
//            Log.e("PercentView", "hightMode UNSPECIFIED");
//        }

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        trackPaint.strokeWidth = width / 12f
        spinningPaint.strokeWidth = width / 12f
        canvas.drawCircle(width / 2f, height / 2f, width / 2f, bgPaint)
        canvas.drawCircle(width / 2f, height / 2f, width / 2f - 10, trackPaint)
        val center_x = width / 2f
        val center_y = height / 2f
        val radius = width / 2f - 10

        val left = center_x - radius
        val top = center_y - radius
        val right = center_x + radius
        val bottom = center_y + radius
        var oval = RectF()
        oval.set(left, top, right, bottom)
        canvas.drawArc(oval, 270f, sweepAngle, false, spinningPaint);
        textPaint.textSize = width / 3f
        val widthText = textPaint.measureText(percentText)
        canvas.drawText(percentText, width / 2f - widthText / 2, height / 2f - textHight / 2, textPaint)
    }

    private fun setup() {
        var trackColor = Color.parseColor("#666666")
        var spinningColor = Color.parseColor("#d4d4d4")
        if (percent > 6.9) {
            trackColor = Color.parseColor("#204529")
            spinningColor = Color.parseColor("#21d07a")
        } else if (percent <= 6.9 && percent > 5) {
            trackColor = Color.parseColor("#423d0f")
            spinningColor = Color.parseColor("#d2d531")
        } else {
            trackColor = Color.parseColor("#571435")
            spinningColor = Color.parseColor("#db2360")
        }
        trackPaint.color = trackColor
        trackPaint.isAntiAlias = true
        trackPaint.style = Paint.Style.STROKE

        bgPaint.color = Color.parseColor("#071d25")
        bgPaint.isAntiAlias = true
        bgPaint.style = Paint.Style.FILL

        spinningPaint.color = spinningColor
        spinningPaint.isAntiAlias = true
        spinningPaint.style = Paint.Style.STROKE
        spinningPaint.setStrokeCap(Paint.Cap.ROUND)

        textPaint.color = Color.WHITE
        textPaint.isAntiAlias = true
        textPaint.style = Paint.Style.FILL
        textPaint.strokeWidth = 20f
        textPaint.typeface = Typeface.SANS_SERIF
        textHight = (textPaint.descent() + textPaint.ascent())
        invalidate()
    }

    fun animatePercent() {
        val animator = ValueAnimator.ofFloat(0f, 360f * percent / 10f)
        animator.duration = 2500
        animator.interpolator = DecelerateInterpolator()
        animator.addUpdateListener { animation ->
            sweepAngle = animation.animatedValue as Float
            invalidate()
        }
        animator.start()
    }
}