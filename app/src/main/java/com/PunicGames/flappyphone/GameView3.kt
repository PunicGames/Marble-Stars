package com.PunicGames.flappyphone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Vibrator
import android.util.AttributeSet
import android.view.View

class GameView3 @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint : Paint = Paint()
        paint.color = Color.RED

        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), 50f, paint)
    }

}