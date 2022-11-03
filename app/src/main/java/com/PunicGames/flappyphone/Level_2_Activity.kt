package com.PunicGames.flappyphone

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class Level_2_Activity : AppCompatActivity() {
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

        //game = findViewById(R.id.gv)

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
        // Meta
        level2.setGoal(9, 1)

        // Limites
        level2.setTWallBlock(0, 0, 1, 32)
        level2.setTWallBlock(17, 0, 18, 32)
        level2.setTWallBlock(0, 0, 18, 1)
        level2.setTWallBlock(0, 31, 18, 32)

        // Paredes Horizontales
        level2.setTWallBlock(1, 4, 15, 5)
        level2.setTWallBlock(1, 8, 15, 9)
        level2.setTWallBlock(1, 8, 15, 9)
        level2.setTWallBlock(1, 8, 15, 9)
        level2.setTWallBlock(5, 12, 7, 13)
        level2.setTWallBlock(1, 11, 2, 12)
        level2.setTWallBlock(12, 11, 17, 12)
        level2.setTWallBlock(3, 20, 9, 21)
        level2.setTWallBlock(1, 27, 10, 28)


        // Paredes Verticales
        level2.setTWallBlock(4, 3, 5, 4)
        level2.setTWallBlock(4, 9, 5, 18)
        level2.setTWallBlock(13, 3, 14, 4)
        level2.setTWallBlock(7, 15, 15, 16)
        level2.setTWallBlock(9, 9, 10, 24)
        level2.setTWallBlock(3, 17, 4, 18)
        level2.setTWallBlock(3, 21, 4, 24)
        level2.setTWallBlock(6, 24, 7, 27)
        level2.setTWallBlock(13, 18, 14, 31)
        level2.setTWallBlock(12, 21, 13, 23)
        level2.setTWallBlock(11, 30, 13, 31)

        // Estrellas
        level2.setStar(6, 1)
        level2.setStar(9, 5)
        level2.setStar(29, 2)
        level2.setStar(30, 15)

        // Agujeros
        level2.setHole(1, 8)
        level2.setHole(5, 11)
        level2.setHole(7, 4)
        level2.setHole(11, 5)
        level2.setHole(14, 10)
        level2.setHole(26, 1)
        level2.setHole(29, 6)
        level2.setHole(25, 15)

        //////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////
        //game!!.layoutParams = ViewGroup.LayoutParams(1080, 1920)
        setContentView(game)

        level2.setBallStartPos(200f,200f)

    }

    override fun onDestroy() {
        super.onDestroy()
        game!!.DeactivateSounds();
    }


}