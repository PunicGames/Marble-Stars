package com.PunicGames.flappyphone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.View
import android.graphics.Paint
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.RequiresApi


class GameView(context: Context, val vibrator: Vibrator) :
    View(context) {

    //Accelerometer variables and vibrator
    var speed: Vector2D = Vector2D(0.0F, 0.0F)
    val TimeStep: Float = 0.4f


    //Ball
    var ballPaint: Paint = Paint()

    var ball: Ball = Ball(0f, 0f, 32f, ballPaint)

    //Level
    var level: Level? = null

    init {
        ballPaint.color = Color.RED
    }


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        level?.draw(canvas)
        ball.draw(canvas)
        invalidate()

        //Log.d(h.toString(), "Height")
    }

    fun onSensorChanged(x: Float, y: Float) {

        var acel = Vector2D(x * -1, y)

        ball.move(speed.x * TimeStep, speed.y * TimeStep)

        speed += acel * TimeStep
        speed *= 0.99F
/*
        if (circleX > (height - view.height) && speed.y > 0){
            speed.y *= -1
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                vibrate()
        }
        if (view.x > (width - view.width) && speed.x > 0){
            speed.x *= -1
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                vibrate()
        }
        if (view.y < 0 && speed.y < 0){
            speed.y *= -1
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                vibrate()
        }
        if (view.x < 0 && speed.x < 0){
            speed.x *= -1
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                vibrate()
        }
        */
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun vibrate() {
        val vibration: VibrationEffect
        vibration = VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE)
        vibrator.cancel()
        vibrator.vibrate(vibration)
    }
}