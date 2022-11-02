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

class Level_4_Activity : AppCompatActivity() {
    lateinit var mSensorManager: SensorManager
    lateinit var mGravitometer: Sensor
    lateinit var mVibrator: Vibrator


    var game: GameView? = null


    private var sensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onSensorChanged(event: SensorEvent) {

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
        var level4: Level = Level(
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

        game!!.level = level4



        //DISEÑA  TU NIVEL AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // Meta
        level4.setGoal(4, 4)

        // Limites
        level4.setTWallBlock(0, 0, 1, 32)
        level4.setTWallBlock(17, 0, 18, 32)
        level4.setTWallBlock(0, 0, 18, 1)
        level4.setTWallBlock(0, 31, 18, 32)


        // Paredes Horizontales
        level4.setTWallBlock(9, 1, 14, 2)
        level4.setTWallBlock(9, 4, 14, 5)
        level4.setTWallBlock(3, 5, 10, 6)
        level4.setTWallBlock(13, 8, 17, 9)
        level4.setTWallBlock(6, 10, 11, 11)
        level4.setTWallBlock(6, 14, 13, 15)
        level4.setTWallBlock(1, 8, 2, 9)
        level4.setTWallBlock(1, 17, 3, 18)
        level4.setTWallBlock(12, 17, 17, 18)
        level4.setTWallBlock(4, 24, 13, 25)
        level4.setTWallBlock(6, 26, 9, 27)
        level4.setTWallBlock(3, 28, 8, 29)
        level4.setTWallBlock(10, 28, 15, 29)

        // Paredes Verticales
        level4.setTWallBlock(3, 1, 4, 6)
        level4.setTWallBlock(4, 1, 5, 2)
        level4.setTWallBlock(5, 6, 6, 10)
        level4.setTWallBlock(4, 7, 5, 8)
        level4.setTWallBlock(4, 9, 5, 10)
        level4.setTWallBlock(9, 11, 10, 12)
        level4.setTWallBlock(3, 11, 4, 15)
        level4.setTWallBlock(8, 14, 9, 18)
        level4.setTWallBlock(4, 19, 5, 25)
        level4.setTWallBlock(6, 25, 7, 26)
        level4.setTWallBlock(12, 17, 13, 29)
        level4.setTWallBlock(6, 11, 7, 14)

        // Estrellas
        level4.setStar(11, 4)
        level4.setStar(11, 7)
        level4.setStar(18, 14)
        level4.setStar(29, 2)

        // Agujeros
        level4.setHole(2, 6)
        level4.setHole(2, 16)
        level4.setHole(4, 6)
        level4.setHole(7, 7)
        level4.setHole(7, 11)
        level4.setHole(7, 12)
        level4.setHole(6, 4)
        level4.setHole(8, 4)
        level4.setHole(10, 4)
        level4.setHole(10, 5)
        level4.setHole(11, 15)
        level4.setHole(18, 1)
        level4.setHole(18, 8)
        level4.setHole(19, 8)
        level4.setHole(20, 8)
        level4.setHole(21, 3)
        level4.setHole(21, 14)
        level4.setHole(23, 5)
        level4.setHole(23, 11)
        level4.setHole(24, 16)
        level4.setHole(25, 1)
        level4.setHole(26, 13)
        level4.setHole(27, 10)
        level4.setHole(29, 7)


        //////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////

        setContentView(game)
        level4.setBallStartPos(200f,200f)

    }

    override fun onDestroy() {
        super.onDestroy()
        game!!.DeactivateSounds();
    }

}