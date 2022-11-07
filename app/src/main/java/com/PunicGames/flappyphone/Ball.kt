package com.PunicGames.flappyphone

import android.graphics.Canvas
import android.graphics.Paint


class Ball(_posX: Float, _posY: Float, _radio: Float, _paint: Paint) {

    var posX: Float = _posX
    var posY: Float = _posY
    var radio: Float = _radio
    var colliderRadio: Float = _radio*0.7f
    var paint: Paint = _paint
    var speed: Vector2D = Vector2D(0.0F, 0.0F)


    fun draw(canvas: Canvas?) {
        canvas?.drawCircle(posX, posY, radio, paint)
    }

    fun move(_posX: Float, _posY: Float) {
        posX += _posX
        posY += _posY
    }



}