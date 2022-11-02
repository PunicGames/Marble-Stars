package com.PunicGames.flappyphone

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
/*
class GravityActivity : AppCompatActivity() {

    private lateinit var mSensorManager: SensorManager
    private lateinit var mGravitometer: Sensor
    private lateinit var mVibrator: Vibrator
    var speed : Vector2D = Vector2D(0.0F, 0.0F)
    val TimeStep : Float =  0.4f
    val AirResistance : Float =  0.05f

    private var width : Float = 0.0f
    private var height : Float = 0.0f

    // Cajas
    private lateinit var textColision: TextView
    var arrBox = ArrayList<BoxCollider>()

    // Bola
    lateinit var ball : ImageView

    //Puntuacion
    private lateinit var scoreText: TextView
    private  var score: Int = 0

    // Objetivos
    var arrObjectives = ArrayList<BoxCollider>()
    var idxGoal : Int = 0

    // Sound and music
    private lateinit var collisionMediaPlayer: MediaPlayer
    private lateinit var backgroundMediaPlayer: MediaPlayer
    private lateinit var goalMediaPlayer: MediaPlayer


    private var sensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onSensorChanged(event: SensorEvent) {
            var mText: TextView = findViewById(R.id.textGravity)

            var str :String = ""
            for(i in 0..2){
                when(i){
                    0-> str += "x:\t"
                    1-> str += "y:\t"
                    2-> str += "z:\t"
                }
                str += event.values[i].toString()
                if(i != 2)
                    str += "\n"
            }
            mText.text = str

            move(findViewById(R.id.ball), event.values[0], event.values[1])

            // Compute collisions with walls
            for (i in 0..arrBox.size - 1){
                if(arrBox[i].checkCollision(ball)){
                    resolveCollision(ball, arrBox[i].view, event.values[0], event.values[1])
                    ball.x = findViewById<View?>(R.id.initPos).x
                    ball.y = findViewById<View?>(R.id.initPos).y
                    vibrate()

                    if(collisionMediaPlayer.isPlaying){
                        collisionMediaPlayer.seekTo(0)
                    }
                    collisionMediaPlayer.start();
                }
            }

            // Compute collisions with objectives
            for (i in 0..arrObjectives.size - 1){
                if(arrObjectives[i].checkCollision(ball) && idxGoal == i){
                    score += 1
                    scoreText.text = "Score: " + score.toString()
                    arrObjectives[i].view.alpha = 0.0f;
                    idxGoal = SelectNewGoal(idxGoal);

                    // Sounds
                    if(goalMediaPlayer.isPlaying){
                        goalMediaPlayer.seekTo(0)
                    }
                    goalMediaPlayer.start()
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gravity)

        width = windowManager.defaultDisplay.width.toFloat()
        height = windowManager.defaultDisplay.height.toFloat()

        mVibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mGravitometer = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        if (mGravitometer != null)
            mSensorManager.registerListener(sensorEventListener, mGravitometer, SensorManager.SENSOR_DELAY_GAME)

        // Text
        textColision = findViewById(R.id.textCollision)
        scoreText = findViewById(R.id.score)
        scoreText.text = "Score: " + score.toString()

        //Sounds
        if(!this::collisionMediaPlayer.isInitialized){
            collisionMediaPlayer = MediaPlayer.create(this, R.raw.hit);
        }
        if(!this::goalMediaPlayer.isInitialized){
            goalMediaPlayer = MediaPlayer.create(this, R.raw.goal);
        }
        if(!this::backgroundMediaPlayer.isInitialized){
            backgroundMediaPlayer = MediaPlayer.create(this, R.raw.background);
            backgroundMediaPlayer.start()
            backgroundMediaPlayer.isLooping = true;
            backgroundMediaPlayer.setVolume(0.2f, 0.2f);
        }

        // LEVEL CONSTRUCTION
        // Limits
        var box1 = BoxCollider(findViewById(R.id.box1), 0.0f, 0.0f, 0.0f)
        var box2 = BoxCollider(findViewById(R.id.box2), 0.0f, 0.0f, 0.0f)
        var box3 = BoxCollider(findViewById(R.id.box3), 0.0f, 0.0f, 0.0f)
        var box4 = BoxCollider(findViewById(R.id.box4), 0.0f, 0.0f, 0.0f)
        arrBox.add(box1)
        arrBox.add(box2)
        arrBox.add(box3)
        arrBox.add(box4)
        // Walls
        var wall1 = BoxCollider(findViewById(R.id.wall1), 0.0f, 0.0f, 0.0f)
        var wall2 = BoxCollider(findViewById(R.id.wall2), 0.0f, 0.0f, 0.0f)
        var wall3 = BoxCollider(findViewById(R.id.wall3), 0.0f, 0.0f, 0.0f)
        var wall4 = BoxCollider(findViewById(R.id.wall4), 0.0f, 0.0f, 0.0f)
        var wall5 = BoxCollider(findViewById(R.id.wall5), 0.0f, 0.0f, 0.0f)
        var wall6 = BoxCollider(findViewById(R.id.wall6), 0.0f, 0.0f, 0.0f)
        var wall7 = BoxCollider(findViewById(R.id.wall7), 0.0f, 0.0f, 0.0f)
        var wall8 = BoxCollider(findViewById(R.id.wall8), 0.0f, 0.0f, 0.0f)
        arrBox.add(wall1)
        arrBox.add(wall2)
        arrBox.add(wall3)
        arrBox.add(wall4)
        arrBox.add(wall5)
        arrBox.add(wall6)
        arrBox.add(wall7)
        arrBox.add(wall8)
        // Ball
        ball = findViewById(R.id.ball)

        // Objectives
        var goal1 = BoxCollider(findViewById(R.id.goal1), 0.0f, 0.0f, 0.0f)
        arrObjectives.add(goal1)
        var goal2 = BoxCollider(findViewById(R.id.goal2), 0.0f, 0.0f, 0.0f)
        arrObjectives.add(goal2)
        var goal3 = BoxCollider(findViewById(R.id.goal3), 0.0f, 0.0f, 0.0f)
        arrObjectives.add(goal3)
        var goal4 = BoxCollider(findViewById(R.id.goal4), 0.0f, 0.0f, 0.0f)
        arrObjectives.add(goal4)

        goal2.view.alpha = 0.0f;
        goal3.view.alpha = 0.0f;
        goal4.view.alpha = 0.0f;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun vibrate()
    {
        val vibration: VibrationEffect
        vibration = VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE)
        mVibrator.cancel()
        mVibrator.vibrate(vibration)
    }

    fun move(view: View, x: Float, y:Float)
    {
        var acel = Vector2D(x  * -1, y)

        view.x += speed.x * TimeStep
        view.y += speed.y * TimeStep

        speed += acel * TimeStep
        speed *= 0.99F

        if (view.y > (height - view.height) && speed.y > 0){
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
    }

    fun resolveCollision(ball: View, box: View, x: Float, y:Float){
        var acel = Vector2D(x  * -1, y)

        ball.x += speed.x * TimeStep
        ball.y += speed.y * TimeStep

        speed += acel * TimeStep
        speed *= 0.99F

        var ballMargin = 10
        var ballXcenter = ball.x + ball.width*0.5
        var ballYcenter = ball.y + ball.height*0.5


        if((ballXcenter  >= box.x) && (ballYcenter  > box.y) && (ballYcenter < (box.y + box.height))){ // Bola chocando por la derecha de la caja
            ball.x = box.x + box.width + ballMargin
            speed.x *= -0.3f
        }
        else if((ballYcenter < box.y) && (ballXcenter > box.x) &&(ballXcenter < box.x + box.width)){       // Bola chocando por arriba de la caja
            ball.y = box.y - ball.height - ballMargin
            speed.y *= -0.3f
        }
        else if((ballYcenter > box.y) && (ballXcenter > box.x) &&(ballXcenter < box.x + box.width)){                     // Bola chocando por abajo de la caja
            ball.y = box.y + box.height + ballMargin;
            speed.y *= -0.3f
        }
        else if((ballXcenter < box.x) && (ballYcenter > box.y) && (ballYcenter < (box.y + box.height))){                     // Bola chocando por la izquierda de la caja
            ball.x = box.x - ball.width - ballMargin
            speed.x *= -0.3f
        }
    }

    fun SelectNewGoal(lastGoal: Int): Int{
        var newGoalIdx = (0..arrObjectives.size - 1).random()
        while (newGoalIdx == lastGoal){
            newGoalIdx = (0..arrObjectives.size - 1).random()
        }

        arrObjectives[newGoalIdx].view.alpha = 1.0f;
        return newGoalIdx;
    }


    override fun onDestroy() {
        if(this::collisionMediaPlayer.isInitialized){
            collisionMediaPlayer.stop()
            collisionMediaPlayer.release()
        }
        if(this::goalMediaPlayer.isInitialized){
            goalMediaPlayer.stop()
            goalMediaPlayer.release()
        }
        if(this::backgroundMediaPlayer.isInitialized){
            backgroundMediaPlayer.stop()
            backgroundMediaPlayer.release()
        }
        super.onDestroy()
    }
}
*/
 