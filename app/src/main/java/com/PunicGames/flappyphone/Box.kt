package com.PunicGames.flappyphone

import android.view.View

class Box (v : View){
    val xMin = v.x
    val yMin = v.y
    val xMax = v.x + v.width
    val yMax = v.y + v.height

    fun print () : String{
        return xMin.toString() + "\n" + yMin.toString();
    }

}