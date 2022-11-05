package com.PunicGames.flappyphone

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.WindowManager
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class Level_1_Activity : AppCompatActivity() {
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
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.game_view_layout)

        game = findViewById(R.id.gv)

        var back: Button = findViewById(R.id.back_button)
        back.setOnClickListener {
            val intent = Intent(this, ComposeMainMenu::class.java)
            startActivity(intent)
            mSensorManager.unregisterListener(sensorEventListener)
            finish()
        }
        game!!.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {

            override fun onGlobalLayout() {
                // Ensure you call it only once
                game!!.viewTreeObserver.removeOnGlobalLayoutListener(this)

                //Level initialization
                var level1: Level = Level(
                    game!!,
                    game!!.width,
                    game!!.height,
                    R.drawable.background,
                    R.drawable.woodwall,
                    R.drawable.goal,
                    R.drawable.estrella,
                    R.drawable.hole
                )

                game!!.level = level1
                game!!.vibrator = mVibrator

                //DISEÑA  TU NIVEL AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                // Meta
                level1.setGoal(2, 15)

                // Limites
                level1.setTWallBlock(0, 0, 1, 32)
                level1.setTWallBlock(17, 0, 18, 32)
                level1.setTWallBlock(0, 0, 18, 1)
                level1.setTWallBlock(0, 31, 18, 32)

                // Paredes Horizontales
                level1.setTWallBlock(1, 4, 3, 5)
                level1.setTWallBlock(3, 8, 5, 9)
                level1.setTWallBlock(1, 12, 8, 13)
                level1.setTWallBlock(1, 16, 5, 17)
                level1.setTWallBlock(3, 28, 13, 29)
                level1.setTWallBlock(11, 11, 14, 12)
                level1.setTWallBlock(8, 17, 12, 18)
                level1.setTWallBlock(11, 21, 14, 22)

                // Paredes Verticales
                level1.setTWallBlock(5, 1, 6, 10)
                level1.setTWallBlock(8, 3, 9, 26)
                level1.setTWallBlock(4, 16, 5, 26)
                level1.setTWallBlock(13, 26, 14, 31)
                level1.setTWallBlock(11, 3, 12, 12)
                level1.setTWallBlock(14, 1, 15, 23)
                level1.setTWallBlock(16, 27, 17, 28)

                // Estrellas
                level1.setStar(30, 16)
                level1.setStar(29, 11)
                level1.setStar(9, 12)
                level1.setStar(15, 1)

                // Agujeros


                //////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////


                level1.setBallStartPosAndSize(200f, 200f)


            }
        })


    }

    override fun onDestroy() {
        super.onDestroy()
        game!!.DeactivateSounds();
    }
}