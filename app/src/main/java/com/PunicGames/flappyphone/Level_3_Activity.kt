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
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.annotation.RequiresApi

class Level_3_Activity : AppCompatActivity() {
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

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val dm = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(dm)

        //Level initialization
        var level3: Level = Level(
            game!!,

            dm.widthPixels,
            dm.heightPixels,
            R.drawable.grass,
            R.drawable.wall_tile,
            R.drawable.goal,
            R.drawable.star,
            R.drawable.hole
        )

        game!!.level = level3



        //DISEÑA  TU NIVEL AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // Meta
        level3.setGoal(29, 15)

        // Limites
        level3.setTWallBlock(0, 0, 1, 32)
        level3.setTWallBlock(17, 0, 18, 32)
        level3.setTWallBlock(0, 0, 18, 1)
        level3.setTWallBlock(0, 31, 18, 32)


        // Paredes Horizontales
        level3.setTWallBlock(1, 6, 4, 7)
        level3.setTWallBlock(9, 4, 15, 5)
        level3.setTWallBlock(13, 8, 17, 9)
        level3.setTWallBlock(4, 10, 13, 11)
        level3.setTWallBlock(10, 12, 13, 13)
        level3.setTWallBlock(1, 14, 5, 15)
        level3.setTWallBlock(7, 19, 17, 20)
        level3.setTWallBlock(10, 22, 14, 23)
        level3.setTWallBlock(13, 23, 17, 24)
        level3.setTWallBlock(4, 28, 11, 29)

        // Paredes Verticales
        level3.setTWallBlock(6, 1, 7, 7)
        level3.setTWallBlock(9, 4, 10, 11)
        level3.setTWallBlock(1, 9, 2, 12)
        level3.setTWallBlock(13, 8, 14, 17)
        level3.setTWallBlock(7, 13, 8, 26)
        level3.setTWallBlock(4, 14, 5, 29)
        level3.setTWallBlock(13, 27, 14, 31)

        // Estrellas
        level3.setStar(9, 11)
        level3.setStar(10, 15)
        level3.setStar(16, 2)
        level3.setStar(21, 15)

        // Agujeros
        level3.setHole(7, 1)
        level3.setHole(2, 7)
        level3.setHole(3, 12)
        level3.setHole(5, 10)
        level3.setHole(7, 16)
        level3.setHole(13, 1)
        level3.setHole(13, 14)
        level3.setHole(15, 10)
        level3.setHole(15, 11)
        level3.setHole(16, 10)
        level3.setHole(16, 11)
        level3.setHole(18, 16)
        level3.setHole(20, 1)
        level3.setHole(21, 10)
        level3.setHole(24, 15)
        level3.setHole(26, 3)
        level3.setHole(29, 8)
        level3.setHole(30, 1)


        //////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////

        setContentView(game)
        level3.setBallStartPosAndSize(200f,200f)

    }

    override fun onDestroy() {
        super.onDestroy()
        game!!.DeactivateSounds();
    }

}