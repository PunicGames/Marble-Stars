package com.PunicGames.flappyphone

import android.view.View

enum class Type {
    wall, goal, hole
}

class BoxCollider(
    val type: Type,
    val xmin: Float,
    val xmax: Float,
    val ymin: Float,
    val ymax: Float
) {



    init {
    }

    fun checkCollision(b: View): Boolean {

        when (type) {
            Type.wall -> {// BOX to BOX collision
                var collisionX = (xmax >= b.x) && (b.x + b.width >= xmin)
                var collisionY = (ymax >= b.y) && (b.y + b.height >= ymin)
                return collisionX && collisionY
            }

            Type.goal -> {
                //Obtener puntos
            }

            Type.hole -> {
                //Perder o bajar vida

            }

            else -> {
                return true
            }

        }
        /*
        // BALL to BOX collision (NOT WORKING)
        // Ball center
        var ballCenter = Vector2D(b.x + (b.width/2), b.y + (b.height/2))
        // AABB info
        var aabbHalfExtents = Vector2D(view.width.toFloat() / 2, view.height.toFloat() / 2)
        var aabbCenter = Vector2D(view.x + aabbHalfExtents.x, view.y + aabbHalfExtents.y)
        // Difference vector between both centers
        var difference = ballCenter.minus(aabbCenter)
        var clampedX = clamp(difference.x, aabbHalfExtents.negate().x, aabbHalfExtents.x)
        var clampedY = clamp(difference.y, aabbHalfExtents.negate().y, aabbHalfExtents.y)
        var clamped = Vector2D(clampedX, clampedY)
        // Add clamped value to aabb center and we get the value of box closest to circle
        var closest = Vector2D(aabbCenter.plus(clamped).x, aabbCenter.plus(clamped).y)
        // Retrieve vector between center circle and closest point AABB and check if length <= radius
        difference = closest.minus(ballCenter)
        return difference.magnitude < b.width
        */

        return false
    }

    fun printAABB(): String {
        return "Xmin: " + this.xmin + ". Xmax: " + this.xmax + ". Ymin: " + this.ymin + ". Ymax: " + this.ymax
    }

    /*
        fun printInfo(): String{
            return "v.x: " + this.view.x + ". v.y: " + this.view.y + ". width: " + this.view.width + ". height: " + view.height
        }
    */
    fun print(): String {
        return xmin.toString()
    }


    // Funciones de apoyo (Debería ir en una clase Utils)
    fun clamp(value: Float, min: Float, max: Float): Float {
        return max(min, min(max, value))
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