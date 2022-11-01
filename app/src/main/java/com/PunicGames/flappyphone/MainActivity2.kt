package com.PunicGames.flappyphone

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity2 : AppCompatActivity() {
        lateinit var mSensorManager: SensorManager
        lateinit var mGravitometer: Sensor
        lateinit var mVibrator: Vibrator



        var game: GameLayout? = null
    private var sensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onSensorChanged(event: SensorEvent) {


            var str: String = ""
            for (i in 0..2) {
                when (i) {
                    0 -> str += "x:\t"
                    1 -> str += "y:\t"
                    2 -> str += "z:\t"
                }
                str += event.values[i].toString()
                if (i != 2)
                    str += "\n"
            }


            game?.move(event.values[0], event.values[1])


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mVibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mGravitometer = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        if (mGravitometer != null)
            mSensorManager.registerListener(sensorEventListener, mGravitometer, SensorManager.SENSOR_DELAY_GAME)

            game =GameLayout(this,1920,1080)
        setContentView(game)

    }




}