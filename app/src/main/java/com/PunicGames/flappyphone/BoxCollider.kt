package com.PunicGames.flappyphone

import android.icu.text.MeasureFormat.FormatWidth
import android.view.View

enum class Type {
    wall, goal, hole, star
}

class BoxCollider(
    val type: Type,
    val xmin: Float,
    val xmax: Float,
    val ymin: Float,
    val ymax: Float,
    val width: Float = xmax - xmin,
    val height: Float = ymax - ymin,
    val center_x : Float = xmin + width*0.5f,
    val center_y : Float = ymin + height*0.5f
) {

    lateinit var tile: Cell


    fun checkCollision(b: Ball): Boolean {

        var collisionX = (b.posX + b.colliderRadio >= xmin) && (b.posX - b.colliderRadio <= xmax)
        var collisionY = (b.posY + b.colliderRadio >= ymin) && (b.posY - b.colliderRadio <= ymax)

        return collisionX && collisionY


    }

    fun max(min: Float, max: Float): Float {
        if (min > max)
            return min
        return max
    }

    fun min(min: Float, max: Float): Float {
        if (min < max)
            return min
        return max
    }

}