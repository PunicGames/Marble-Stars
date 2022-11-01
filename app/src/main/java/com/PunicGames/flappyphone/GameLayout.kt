package com.PunicGames.flappyphone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import android.graphics.Matrix
import android.graphics.Paint
import android.os.Build
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView


class GameLayout (context : Context, screenWidth: Int, screenHeight: Int): View(context){
    var speed : Vector2D = Vector2D(0.0F, 0.0F)
    val TimeStep : Float =  0.4f

    var w: Int = 0
    var h: Int = 0
    var walkable: Bitmap
    var wall: Bitmap
    var sizeOfMap: Int = screenWidth/screenHeight
    val col: Int = 17
    val row: Int = 30
    val cells = ArrayList<Cell>()

    var circleX : Float = 200f;
    var circleY : Float = 200f;
    var paint : Paint = Paint()


    init {
        // Screen initialization
        w = screenWidth
        h = screenHeight
        paint.color = Color.RED

        walkable = BitmapFactory.decodeResource(this.resources, R.drawable.grass)
        walkable = Bitmap.createScaledBitmap(walkable, 100, 100, false)
        wall = BitmapFactory.decodeResource(this.resources, R.drawable.wall)
        wall = Bitmap.createScaledBitmap(wall, 100, 100, true)


        for (i in 0..row - 1) {
            for (j in 0..col - 1) {
                /*

                    var Cell = Cell(walkable,i,j,j*100f, i*100f, 100, 100, Type.floor)
                    cells.add(Cell)
                    */

                if (i == 0 || i== 29 || j == 0 || j == 16) {
                    var grassObj = Cell(wall,i,j,j*64f, i*64f, 64, 64, Type.wall)
                    cells.add(grassObj)
                } else {
                    var grassObj = Cell(walkable,i,j,j*64f, i*64f, 64, 64, Type.floor)
                    cells.add(grassObj)
                }
            }
        }


    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        for(i in 0..cells.size - 1){
            canvas?.drawBitmap(cells[i].bitmap, cells[i].posX, cells[i].posY, null)
        }
        canvas?.drawCircle(circleX,circleY,32F, paint)
        invalidate()

        Log.d(w.toString(), "Width")
        Log.d(h.toString(), "Height")
    }
    fun move(x: Float, y:Float)
    {

        var acel = Vector2D(x  * -1, y)

        circleX+= speed.x * TimeStep
        circleY += speed.y * TimeStep

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
}