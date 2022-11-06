package com.PunicGames.flappyphone

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import androidx.annotation.RequiresApi

open class Level_Activity : AppCompatActivity() {
    lateinit var mSensorManager: SensorManager
    lateinit var mGravitometer: Sensor
    lateinit var mVibrator: Vibrator

    var game: GameView? = null

    var sensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onSensorChanged(event: SensorEvent) {

            game?.onSensorChanged(event.values[0], event.values[1])

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun finishActivity()
    {
        mSensorManager.unregisterListener(sensorEventListener)
        finish()
    }
}