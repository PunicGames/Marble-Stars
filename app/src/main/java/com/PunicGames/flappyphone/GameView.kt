package com.PunicGames.flappyphone

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

class GameView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    //Accelerometer variables and vibrator
    val TimeStep: Float = 0.2f
    var vibrator: Vibrator? = null

    //Music and SFX
    private lateinit var collisionMediaPlayer: MediaPlayer
    private lateinit var backgroundMediaPlayer: MediaPlayer
    private lateinit var starMediaPlayer: MediaPlayer
    private lateinit var rollingBallPlayer: MediaPlayer
    private lateinit var holeSound: MediaPlayer


    //Ball
    var ballPaint: Paint = Paint()
    var ball: Ball = Ball(0f, 0f, 25f, ballPaint)

    //Level
    var level: Level? = null

    //Points
    var points: Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    val initTime = LocalDateTime.now()

    init {
        //Sounds
        if (!this::collisionMediaPlayer.isInitialized) {
            collisionMediaPlayer = MediaPlayer.create(context, R.raw.hit);
        }
        if (!this::starMediaPlayer.isInitialized) {
            starMediaPlayer = MediaPlayer.create(context, R.raw.goal);
            starMediaPlayer.setVolume(1.0f, 1.0f);
        }
        if (!this::backgroundMediaPlayer.isInitialized) {
            backgroundMediaPlayer = MediaPlayer.create(context, R.raw.background);
            backgroundMediaPlayer.start()
            backgroundMediaPlayer.isLooping = true;
            backgroundMediaPlayer.setVolume(0.2f, 0.2f);
        }
        if (!this::rollingBallPlayer.isInitialized) {
            rollingBallPlayer = MediaPlayer.create(context, R.raw.rolling);
            rollingBallPlayer.start();
            rollingBallPlayer.isLooping = true;
            rollingBallPlayer.setVolume(0.0f, 0.0f);
        }
        if (!this::holeSound.isInitialized) {
            holeSound = MediaPlayer.create(context, R.raw.hole);
            holeSound.setVolume(1.0f, 1.0f);
        }
        ballPaint.color = Color.rgb(220, 25, 75)
    }

/*
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
    }

 */

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        level?.draw(canvas)
        ball.draw(canvas)
        invalidate()

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
        if (factorX < 0) {
            factorX *= -1;
        }
        if (factorY < 0) {
            factorY *= -1;
        }
        var factor = (factorX + factorY) / 2
        rollingBallPlayer.setVolume(factor * 0.05f, factor * 0.05f);


        // Collision
        checkCollisions()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun resolveCollision(ball: Ball, box: BoxCollider, x: Float, y: Float) {

        when (box.type) {
            Type.wall -> {

                if ((ball.posY >= box.center_y - box.height * 0.5f) && (ball.posY <= (box.center_y + box.height * 0.5f))){
                    if (ball.speed.x < 0)
                        ball.posX += ball.colliderRadio*0.2F else ball.posX -= ball.colliderRadio*0.2F
                ball.speed.x *= -1
                }
                else if ((ball.posX >= box.center_x - box.width * 0.5f) && (ball.posX <= (box.center_x + box.width * 0.5f))) {
                    if (ball.speed.y < 0)
                        ball.posY += ball.colliderRadio*0.2F else ball.posY -= ball.colliderRadio*0.2F
                    ball.speed.y *= -1
                }else {
                    ball.speed.x *= -1
                    ball.speed.y *= -1
                }


/*
                if (box.checkIntersection(ball.posX,ball.posY,ball.posX-ball.colliderRadio,ball.posY,box.xmax,box.ymax,box.xmax,box.ymin) && box.checkIntersection(ball.posX+ball.colliderRadio,ball.posY,ball.posX,ball.posY,box.xmin,box.ymax,box.xmin,box.ymin))
                    ball.speed.x *= -1
                if(box.checkIntersection(ball.posX,ball.posY,ball.posX,ball.posY-ball.colliderRadio,box.xmax,box.ymax,box.xmin,box.ymax) && box.checkIntersection(ball.posX,ball.posY+ball.colliderRadio,ball.posX,ball.posY,box.xmax,box.ymin,box.xmin,box.ymin))
                    ball.speed.y *= -1
*/


/*
                // Version JAVI S.

                if((ball.posX > box.center_x) && (ball.posY >= box.center_y - box.height) && (ball.posY <= (box.center_y + box.height)))// Bola chocando por la derecha de la caja
                {
                    ball.speed.x= -ball.speed.x

                }

                if((ball.posX < box.center_x) && (ball.posY >= box.center_y - box.height) && (ball.posY <= (box.center_y + box.height)))// Bola chocando por la izquierda de la caja
                {
                    ball.speed.x= -ball.speed.x
                }

                if((ball.posY > box.center_y ) && (ball.posX >= box.center_x - box.width) && (ball.posX <= box.center_x + box.width))// Bola chocando por abajo de la caja
                {
                    ball.speed.y= -ball.speed.y
                }

                if((ball.posY < box.center_y ) && (ball.posX >= box.center_x - box.width) && (ball.posX <= box.center_x + box.width))
                {
                    ball.speed.y=-ball.speed.y
                }



 */


            }

            Type.goal -> {
                //Obtener puntos y finalizar partida
                DeactivateSounds();
                val intent = Intent(context, ComposeResumeLevelActivity::class.java)
                val finishTime = LocalDateTime.now()
                var initTimeInSeconds = initTime.minute * 60 + initTime.second;
                var finishTimeInSeconds = finishTime.minute * 60 + finishTime.second;
                var totalSeconds = finishTimeInSeconds - initTimeInSeconds;
                var minutes = (totalSeconds / 60).toInt()
                var seconds = totalSeconds - minutes * 60
                intent.putExtra("points", points)
                intent.putExtra("minutes", minutes)
                intent.putExtra("seconds", seconds)
                context.startActivity(intent);

                var gameContext: Level_Activity = context as Level_Activity
                gameContext.finishActivity()


            }

            Type.star -> {
                if (!box.tile.collected) {
                    // Sonido
                    if (starMediaPlayer.isPlaying) {
                        starMediaPlayer.seekTo(0)
                    }
                    starMediaPlayer.start();

                    //Obtener puntos
                    points += 1;
                    box.tile.collected = true;
                    //box.tile.posX = -100f;

                }
            }

            Type.hole -> {
                //Perder o bajar vida o devolver al inicio
                ball.posX = 120f;
                ball.posY = 120f;
                points = 0
                for (i in 0..level?.starColliders!!.size - 1) {
                    level?.starColliders!![i].tile.collected = false
                }

                holeSound.seekTo(0)
                holeSound.start()
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
    fun checkCollisions() {

        if (level != null) { //If level is not already created

            for (i in 0..level?.colliders!!.size - 1) {

                if (level?.colliders!![i].checkCollision(ball)) {
                    // Colision con muro
                    if (level?.colliders!![i].type == Type.wall) {
                        vibrate()

                        if (collisionMediaPlayer.isPlaying) {
                            collisionMediaPlayer.seekTo(0)
                        }
                        collisionMediaPlayer.start();
                    }

                    resolveCollision(ball, level?.colliders!![i], x, y)
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun vibrate() {
        val vibration: VibrationEffect
        vibration = VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE)
        vibrator?.cancel()
        vibrator?.vibrate(vibration)
    }

    fun DeactivateSounds() {
        if (this::collisionMediaPlayer.isInitialized) {
            collisionMediaPlayer.stop()
            collisionMediaPlayer.release()
        }
        if (this::starMediaPlayer.isInitialized) {
            starMediaPlayer.stop()
            starMediaPlayer.release()
        }
        if (this::rollingBallPlayer.isInitialized) {
            rollingBallPlayer.stop()
            rollingBallPlayer.release()
        }
        if (this::backgroundMediaPlayer.isInitialized) {
            backgroundMediaPlayer.stop()
            backgroundMediaPlayer.release()
        }
        if (this::holeSound.isInitialized) {
            holeSound.stop()
            holeSound.release()
        }
    }

}