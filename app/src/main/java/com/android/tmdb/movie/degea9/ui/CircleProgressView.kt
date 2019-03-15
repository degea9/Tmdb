package com.android.tmdb.movie.degea9.ui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint


class CircleProgressView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    val bgpaint = Paint()
    val bgPaint1 = Paint()
    val spinningPaint = Paint()
    val textPaint = TextPaint()
    var sweepAngle = 0f;
    var percentText:String = ""
    var percent = 0f
        set(value) {
            if (value >= 0) {
                field = value
                percentText = (value*100).toString()
                animatePercent()
            }
        }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.e("CircleProgressView", "widthMeasureSpec " + widthMeasureSpec + " heightMeasureSpec " + heightMeasureSpec)
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = View.MeasureSpec.getSize(heightMeasureSpec)
        val widthMode = View.MeasureSpec.getMode(widthMeasureSpec)
        val hightMode = View.MeasureSpec.getMode(heightMeasureSpec)
        Log.e(
            "CircleProgressView",
            "width " + width + " widthMode " + widthMode + " hightMode " + hightMode + " height " + height
        )
        if (widthMode == MeasureSpec.EXACTLY) {
            Log.e("CircleProgressView", "widthMode EXACTLY");
        } else if (widthMode == MeasureSpec.AT_MOST) {
            Log.e("CircleProgressView", "widthMode AT_MOST");
        } else if (widthMode == MeasureSpec.UNSPECIFIED) {
            Log.e("CircleProgressView", "widthMode UNSPECIFIED");
        }

        if (hightMode == MeasureSpec.EXACTLY) {
            Log.e("CircleProgressView", "hightMode EXACTLY");
        } else if (hightMode == MeasureSpec.AT_MOST) {
            Log.e("CircleProgressView", "hightMode AT_MOST");
        } else if (hightMode == MeasureSpec.UNSPECIFIED) {
            Log.e("CircleProgressView", "hightMode UNSPECIFIED");
        }

        setMeasuredDimension(height, height)
    }

    override fun onDraw(canvas: Canvas) {
        bgpaint.color = Color.parseColor("#204529")
        bgpaint.isAntiAlias = true
        bgpaint.style = Paint.Style.STROKE
        bgpaint.strokeWidth = 20f

        bgPaint1.color = Color.parseColor("#071d25")
        bgPaint1.isAntiAlias = true
        bgPaint1.style = Paint.Style.FILL

        spinningPaint.color = Color.parseColor("#21d07a")
        spinningPaint.isAntiAlias = true
        spinningPaint.style = Paint.Style.STROKE
        spinningPaint.strokeWidth = 20f

        textPaint.color = Color.WHITE
        textPaint.isAntiAlias = true
        textPaint.style = Paint.Style.FILL
        textPaint.strokeWidth = 20f
        textPaint.textSize = 100f
        canvas.drawCircle(width / 2f, height / 2f, width / 3f+20, bgPaint1)
        canvas.drawCircle(width / 2f, height / 2f, width / 3f, bgpaint)
        val center_x = width / 2f
        val center_y = height / 2f
        val radius = width / 3f

        val left = center_x - radius
        val top = center_y - radius
        val right = center_x + radius
        val bottom = center_y + radius
        val oval = RectF()
        oval.set(left, top, right, bottom)
        canvas.drawArc(oval, 270f, sweepAngle, false, spinningPaint);

        val widthText = textPaint.measureText(percentText)
        Log.e("tuandang","width text "+widthText+ " text size "+textPaint.textSize)
        canvas.drawText(percentText,width/2f-widthText/2,height/2f+textPaint.textSize/2,textPaint)
    }


    fun animatePercent() {
        val animator = ValueAnimator.ofFloat(0f, 360f *percent)
        animator.duration = 2500
        animator.interpolator = DecelerateInterpolator()
        animator.addUpdateListener { animation ->
            sweepAngle = animation.animatedValue as Float
            invalidate()
        }
        animator.start()
    }
}