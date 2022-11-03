package com.PunicGames.flappyphone

import android.graphics.Bitmap
import android.view.View



class Cell (bitmapi:Bitmap,col_:Int,row_:Int, x: Float, y:Float){

    var bitmap: Bitmap = bitmapi
    var posX : Float = x
    var posY : Float = y
    var collected : Boolean = false


}
