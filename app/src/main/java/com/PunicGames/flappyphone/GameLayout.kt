package com.PunicGames.flappyphone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import android.graphics.Matrix
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView


class GameLayout (context : Context, screenWidth: Int, screenHeight: Int): View(context){

    var w: Int = 0
    var h: Int = 0
    var walkable: Bitmap
    var wall: Bitmap
    var sizeOfMap: Int = 1080/91
    val col: Int = 15
    val row: Int = 30
    val cells = ArrayList<Cell>()

    init {
        // Screen initialization
        w = screenWidth
        h = screenHeight


        walkable = BitmapFactory.decodeResource(this.resources, R.drawable.grass)
        walkable = Bitmap.createScaledBitmap(walkable, 100, 100, false)
        wall = BitmapFactory.decodeResource(this.resources, R.drawable.grass03)
        wall = Bitmap.createScaledBitmap(wall, 100, 100, true)


        for(i in 0..row - 1){
            for(j in 0..col - 1){
                    var Cell = Cell(walkable,i,j,j*100f, i*100f, 100, 100, Type.floor)
                    cells.add(Cell)
                }
            }
        }




    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        for(i in 0..cells.size - 1){
            canvas?.drawBitmap(cells[i].bitmap, cells[i].posX, cells[i].posY, null)
        }
        Log.d(w.toString(), "Width")
        Log.d(h.toString(), "Height")
    }
}