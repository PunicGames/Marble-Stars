package com.PunicGames.flappyphone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.View
import android.graphics.Paint
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import androidx.annotation.RequiresApi
import android.content.Intent


class GameView(context: Context, val vibrator: Vibrator) :
    View(context) {

    //Accelerometer variables and vibrator
    val TimeStep: Float = 0.25f

    //Music and SFX
    private lateinit var collisionMediaPlayer: MediaPlayer
    private lateinit var backgroundMediaPlayer: MediaPlayer
    private lateinit var goalMediaPlayer: MediaPlayer
    private lateinit var rollingBallPlayer: MediaPlayer


    //Ball
    var ballPaint: Paint = Paint()
    var ball: Ball = Ball(0f, 0f, 25f, ballPaint)

    //Level
    var level: Level? = null

    //Points
    var points: Int = 0


    init {
        //Sounds
        if (!this::collisionMediaPlayer.isInitialized) {
            collisionMediaPlayer = MediaPlayer.create(context, R.raw.hit);
        }
        if (!this::goalMediaPlayer.isInitialized) {
            goalMediaPlayer = MediaPlayer.create(context, R.raw.goal);
        }
        if (!this::backgroundMediaPlayer.isInitialized) {
            backgroundMediaPlayer = MediaPlayer.create(context, R.raw.background);
            backgroundMediaPlayer.start()
            backgroundMediaPlayer.isLooping = true;
            backgroundMediaPlayer.setVolume(0.2f, 0.2f);
        }
        if(!this::rollingBallPlayer.isInitialized){
            rollingBallPlayer = MediaPlayer.create(context, R.raw.rolling);
            rollingBallPlayer.start();
            rollingBallPlayer.isLooping = true;
            rollingBallPlayer.setVolume(0.0f, 0.0f);
        }


        ballPaint.color = Color.RED
    }


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        level?.draw(canvas)
        ball.draw(canvas)
        invalidate()
        //Log.d(height.toString(), "Height")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onSensorChanged(x: Float, y: Float) {

        var acel = Vector2D(x * -1, y)

        ball.move(ball.speed.x * TimeStep, ball.speed.y * TimeStep)

        ball.speed += acel * TimeStep
        ball.speed *= 0.99F

        // Change sound
        var factorX = ball.speed.x
        var factorY = ball.speed.y
        if(factorX < 0){
            factorX *= -1;
        }
        if(factorY < 0){
            factorY *= -1;
        }
        var factor = (factorX + factorY) / 2
        rollingBallPlayer.setVolume(factor * 0.05f, factor * 0.05f);


        // Collision
        checkCollisions()

    }
    fun resolveCollision(ball: Ball, box: BoxCollider, x: Float, y:Float){

            when (box.type) {
                Type.wall -> {
                    var boxWidth = box.xmax - box.xmin;
                    var boxHeight = box.ymax - box.ymin;
                    var boxXCenter = box.xmin + boxWidth*0.5f;
                    var boxYCenter = box.ymin + boxHeight*0.5f;

                    if((ball.posX >= boxXCenter) && (ball.posY > boxYCenter - boxHeight) && (ball.posY < (boxYCenter + boxHeight)))// Bola chocando por la derecha de la caja
                    {
                        ball.speed.x= -ball.speed.x
                    }
                    if((ball.posX < boxXCenter) && (ball.posY > boxYCenter - boxHeight) && (ball.posY < (boxYCenter + boxHeight)))// Bola chocando por la izquierda de la caja
                    {
                        ball.speed.x= -ball.speed.x
                    }
                    if((ball.posY > boxYCenter) && (ball.posX > boxXCenter - boxWidth) && (ball.posX < boxXCenter + boxWidth))// Bola chocando por abajo de la caja
                    {
                        ball.speed.y= -ball.speed.y

                    }
                    if((ball.posY < boxYCenter) && (ball.posX > boxXCenter - boxWidth) && (ball.posX < boxXCenter + boxWidth))
                    {
                        ball.speed.y=-ball.speed.y

                    }
                }

                Type.goal -> {
                    //Obtener puntos y finalizar partida
                    DeactivateSounds();
                    val intent = Intent(context, LevelSelectionActivity::class.java)
                    context.startActivity(intent);
                }
                Type.star -> {
                    //Obtener puntos

                }

                Type.hole -> {
                    //Perder o bajar vida o devolver al inicio

                }

                else -> {

                }

            }
        /*
        var acel = Vector2D(x  * -1, y)

        ball.move(speed.x * TimeStep, speed.y * TimeStep)

        speed += acel * TimeStep
        speed *= 0.99F

        if((ball.posX  >= box.xmin) && (ball.posY  > box.ymin) && (ball.posY < (box.ymax))){ // Bola chocando por la derecha de la caja
            ball.posX = box.xmin + box.width
            speed.x *= -0.3f
        }
        else if((ball.posY < box.ymin) && (ball.posX > box.xmin) &&(ball.posX  < box.xmax)){// Bola chocando por arriba de la caja
            ball.posY = box.ymin - ball.radio
            speed.y *= -0.3f
        }
        else if((ball.posY > box.ymin) && (ball.posX > box.xmin) &&(ball.posX  < box.xmax)){// Bola chocando por abajo de la caja
            ball.posY = box.ymin + box.height
            speed.y *= -0.3f
        }
        else if((ball.posX  < box.xmin) && (ball.posY > box.ymin) && (ball.posY < (box.ymax))){                     // Bola chocando por la izquierda de la caja
            ball.posX = box.xmin - ball.radio
            speed.x *= -0.3f
        }

         */
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun checkCollisions(){
        for (i in 0..level?.colliders!!.size - 1) {

            if (level?.colliders!![i].checkCollision(ball)) {
                // Colision con muro
                if (level?.colliders!![i].type == Type.wall) {
                    resolveCollision(ball, level?.colliders!![i], x, y)

                    vibrate()

                    if (collisionMediaPlayer.isPlaying) {
                        collisionMediaPlayer.seekTo(0)
                    }
                    collisionMediaPlayer.start();
                }

                // Colision con meta
                if (level?.colliders!![i].type == Type.goal) {

                    if (goalMediaPlayer.isPlaying) {
                        goalMediaPlayer.seekTo(0)
                    }
                    goalMediaPlayer.start();

                    resolveCollision(ball, level?.colliders!![i], x, y)
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun vibrate() {
        val vibration: VibrationEffect
        vibration = VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE)
        vibrator.cancel()
        vibrator.vibrate(vibration)
    }

    fun DeactivateSounds(){
        if(this::collisionMediaPlayer.isInitialized){
            collisionMediaPlayer.stop()
            collisionMediaPlayer.release()
        }
        if(this::goalMediaPlayer.isInitialized){
            goalMediaPlayer.stop()
            goalMediaPlayer.release()
        }
        if(this::rollingBallPlayer.isInitialized){
            rollingBallPlayer.stop()
            rollingBallPlayer.release()
        }
        if(this::backgroundMediaPlayer.isInitialized){
            backgroundMediaPlayer.stop()
            backgroundMediaPlayer.release()
        }
    }

}