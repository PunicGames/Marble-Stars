package com.PunicGames.flappyphone

import android.graphics.Bitmap
import android.view.View

enum class Type{
    wall,floor
}

class Cell (bitmapi:Bitmap,row_:Int, col_:Int,x: Float, y:Float, widthi:Int, heighti:Int, t: Type){

    var bitmap: Bitmap = bitmapi
    var Col: Int = col_
    var Row: Int = row_
    var posX : Float = x
    var posY : Float = y
    var width: Int =widthi
    var height: Int =heighti
    var type: Type = t


    fun checkCollision(ball: View) {

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

        //BALL TO BOX
        var bCenter = Vector2D(ball.x + (ball.width/2), ball.y + (ball.height/2))



        // BOX to BOX collision
        var collisionX = ( xmax>= ball.x) && (ball.x + ball.width >= xmin)
        var collisionY = (ymax >= ball.y) && (ball.y + ball.height >= ymin)
        return collisionX && collisionY

         */
    }

}
