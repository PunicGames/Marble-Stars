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
import androidx.annotation.RequiresApi

class Level_2_Activity : AppCompatActivity() {
    lateinit var mSensorManager: SensorManager
    lateinit var mGravitometer: Sensor
    lateinit var mVibrator: Vibrator


    var game: GameView? = null


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


            game?.onSensorChanged(event.values[0], event.values[1])


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mVibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mGravitometer = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        if (mGravitometer != null)
            mSensorManager.registerListener(
                sensorEventListener,
                mGravitometer,
                SensorManager.SENSOR_DELAY_GAME
            )


        game = GameView(
            this, mVibrator
            //////////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////
            //LEVEL SETUP
        )

        //Level initialization
        var level2: Level = Level(
            game!!,
            18,
            32,
            1920,
            1080,
            R.drawable.grass,
            R.drawable.wall_tile,
            R.drawable.goal,
            R.drawable.star,
            R.drawable.hole
        )

        game!!.level = level2

        //DISEÑA  TU NIVEL AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        level2.setTWallBlock(0, 0, 18, 1)
        level2.setTWallBlock(12, 3, 14, 15)

        level2.setGoal(14, 16)
        level2.setStar(12, 16)

        level2.setStar(14,30)


        //////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////

        setContentView(game)
        level2.setBallStartPos(200f,200f)

    }


}