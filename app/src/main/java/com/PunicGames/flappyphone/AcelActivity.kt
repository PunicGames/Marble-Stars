package com.PunicGames.flappyphone

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs


class AcelActivity : AppCompatActivity(){

    private lateinit var mSensorManager: SensorManager
    private lateinit var mAccelerometer: Sensor
    private val activationThreshold: Float = 0.1F

    private var sensorEventListener = object :SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

        override fun onSensorChanged(event: SensorEvent) {
            var mText: TextView = findViewById(R.id.textView)
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

            moveText(mText, event.values[0], event.values[1])

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acel)
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)
        if(mAccelerometer != null)
            mSensorManager.registerListener(sensorEventListener, mAccelerometer, SensorManager.SENSOR_DELAY_GAME)

    }

    fun moveText(view: View,x: Float, y: Float ){
        if (abs(x) > activationThreshold)
            view.x += x
        if (abs(y) > activationThreshold)
            view.y += y * 2.5F
    }
}