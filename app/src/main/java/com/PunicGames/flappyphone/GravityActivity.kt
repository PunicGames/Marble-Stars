package com.PunicGames.flappyphone

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi

class GravityActivity : AppCompatActivity() {

    private lateinit var mSensorManager: SensorManager
    private lateinit var mGravitometer: Sensor
    private lateinit var mVibrator: Vibrator
    var speed : Vector2D = Vector2D(0.0F, 0.0F)
    val TimeStep : Float =  0.4f
    val AirResistance : Float =  0.05f

    private var width : Float = 0.0f
    private var height : Float = 0.0f

    private var stopXmovement : Boolean = false
    private var stopYmovement : Boolean = false

    // Cajas
    private lateinit var textColision: TextView
    var arrBox = ArrayList<Box>()

    private var sensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

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

            move(findViewById(R.id.dot), event.values[0], event.values[1])

            // Compute collisions
            var ball : ImageView = findViewById(R.id.dot)
            for (i in 0..arrBox.size - 1){
                if(arrBox[i].checkCollision(ball)){
                    resolveCollision(ball, arrBox[i].view, event.values[0], event.values[1])
                    //textColision.text = arrBox[0].checkCollision(findViewById(R.id.dot)).toString()
                }else{
                    stopXmovement = false;
                    stopYmovement = false;
                }

            }
            // Texto de prueba FUNCIONA JEJE
            //textColision.text = arrBox[0].printAABB()
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

        // Boxes
        var box1 = Box(findViewById(R.id.box1))
        var box2 = Box(findViewById(R.id.box2))
        var box3 = Box(findViewById(R.id.box3))
        var box4 = Box(findViewById(R.id.box4))
        var box5 = Box(findViewById(R.id.box5))
        arrBox.add(box1)
        arrBox.add(box2)
        arrBox.add(box3)
        arrBox.add(box4)
        arrBox.add(box5)

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

        //if(!stopXmovement)
            view.x += speed.x * TimeStep
        //if(!stopYmovement)
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
            stopXmovement = true;
            speed.x *= -0.1f
        }
        else if((ballYcenter < box.y) && (ballXcenter > box.x) &&(ballXcenter < box.x + box.width)){       // Bola chocando por arriba de la caja
            ball.y = box.y - ball.height - ballMargin
            speed.y *= -0.1f
        }
        else if((ballYcenter > box.y) && (ballXcenter > box.x) &&(ballXcenter < box.x + box.width)){                     // Bola chocando por abajo de la caja
            ball.y = box.y + box.height + ballMargin;
            speed.y *= -0.1f
        }
        else if((ballXcenter < box.x) && (ballYcenter > box.y) && (ballYcenter < (box.y + box.height))){                     // Bola chocando por la izquierda de la caja
            ball.x = box.x - ball.width - ballMargin
            speed.x *= -0.1f
        }


    }
}