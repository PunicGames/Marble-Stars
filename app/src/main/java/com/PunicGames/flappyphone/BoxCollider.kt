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
    fun checkIntersection(p0_x: Float, p0_y: Float, p1_x: Float, p1_y: Float,
                          p2_x: Float,p2_y: Float, p3_x: Float,p3_y: Float): Boolean{

        var s1_x: Float = p1_x - p0_x
        var s1_y: Float = p1_y - p0_y;
        var s2_x: Float = p3_x - p2_x;
        var s2_y : Float= p3_y - p2_y;


        var s: Float = (-s1_y * (p0_x - p2_x) + s1_x * (p0_y - p2_y)) / (-s2_x * s1_y + s1_x * s2_y);
        var t: Float = ( s2_x * (p0_y - p2_y) - s2_y * (p0_x - p2_x)) / (-s2_x * s1_y + s1_x * s2_y);

        if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
        {
            // Collision detected

            return true;
        }

        return false; // No collision
    }

    /*



        if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
        {
            // Collision detected
            if (i_x != NULL)
            *i_x = p0_x + (t * s1_x);
            if (i_y != NULL)
            *i_y = p0_y + (t * s1_y);
            return 1;
        }

        return 0; // No collision
    }

     */



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