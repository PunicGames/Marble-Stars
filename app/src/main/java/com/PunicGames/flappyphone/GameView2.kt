package com.PunicGames.flappyphone

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.SurfaceView
import android.view.SurfaceHolder

/**
 * GameView is our playground.
 */

class GameView2(context: Context, attributes: AttributeSet) : SurfaceView(context, attributes), SurfaceHolder.Callback {
    private val thread: GameThread

    init {

        // add callback
        holder.addCallback(this)

        // instantiate the game thread
        thread = GameThread(holder, this)
    }


    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        // start the game thread
        thread.setRunning(true)
        thread.start()
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {

    }

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
        var retry = true
        while (retry) {
            try {
                thread.setRunning(false)
                thread.join()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            retry = false
        }
    }

    /**
     * Function to update the positions of player and game objects
     */
    fun update() {

    }

    /**
     * Everything that has to be drawn on Canvas
     */
    override fun draw(canvas: Canvas) {
        super.draw(canvas)
    }

}