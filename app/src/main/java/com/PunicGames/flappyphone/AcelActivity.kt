package com.PunicGames.flappyphone

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService


class AcelActivity : AppCompatActivity(){

    private lateinit var mSensorManager: SensorManager
    private lateinit var mAccelerometer: Sensor
    private var sensorEventListener = object :SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

        override fun onSensorChanged(event: SensorEvent) {
            var text :TextView = findViewById(R.id.textView)
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
            text.text = str
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acel)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        if(mAccelerometer != null){
            mSensorManager.registerListener(sensorEventListener, mAccelerometer, SensorManager.SENSOR_DELAY_GAME)
        }

    }
}