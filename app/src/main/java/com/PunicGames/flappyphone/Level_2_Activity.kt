package com.PunicGames.flappyphone

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.WindowManager
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class Level_2_Activity : Level_Activity() {

    private lateinit var buttonEffect: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mVibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
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

        buttonEffect = MediaPlayer.create(this, R.raw.button);
        buttonEffect.setVolume(0.6f, 0.6f)

        var back: Button = findViewById(R.id.back_button)
        back.setOnClickListener {
            buttonEffect.seekTo(0)
            buttonEffect.start()

            val intent = Intent(this, ComposeMainMenu::class.java)
            startActivity(intent)
            mSensorManager.unregisterListener(sensorEventListener)
            game!!.DeactivateSounds()
            finish()
        }

        game!!.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {

            override fun onGlobalLayout() {
                // Ensure you call it only once
                game!!.viewTreeObserver.removeOnGlobalLayoutListener(this)

                //Level initialization
                var level2: Level = Level(
                    game!!,

                    game!!.width,
                    game!!.height,
                    R.drawable.background,
                    R.drawable.woodwall,
                    R.drawable.goal,
                    R.drawable.estrella,
                    R.drawable.hole
                )

                game!!.level = level2
                game!!.vibrator = mVibrator

                //DISEÑA  TU NIVEL AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                // Meta
                level2.setGoal(9, 1)
                //level2.debug = true

                // Limites
                level2.setTWallBlock(0, 0, 1, 32)
                level2.setTWallBlock(17, 0, 18, 32)
                level2.setTWallBlock(1, 0, 17, 1)
                level2.setTWallBlock(1, 31, 17, 32)

                // Paredes Horizontales
                level2.setTWallBlock(1, 4, 15, 5)
                level2.setTWallBlock(1, 8, 15, 9)
                level2.setTWallBlock(5, 12, 7, 13)
                level2.setTWallBlock(1, 11, 2, 12)
                level2.setTWallBlock(12, 11, 17, 12)
                level2.setTWallBlock(3, 20, 9, 21)
                level2.setTWallBlock(1, 27, 10, 28)
                level2.setTWallBlock(7, 15, 9, 16)
                level2.setTWallBlock(10, 15, 15, 16)


                // Paredes Verticales
                level2.setTWallBlock(4, 3, 5, 4)
                level2.setTWallBlock(4, 9, 5, 18)
                level2.setTWallBlock(13, 3, 14, 4)
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

                level2.setBallStartPosAndSize(200f,200f)

            }
        })


    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
