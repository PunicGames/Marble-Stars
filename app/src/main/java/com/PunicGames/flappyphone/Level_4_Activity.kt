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


class Level_4_Activity : Level_Activity() {

    private lateinit var buttonEffect: MediaPlayer

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

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

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
                var level4: Level = Level(
                    game!!,
                    game!!.width,
                    game!!.height,
                    R.drawable.background,
                    R.drawable.woodwall,
                    R.drawable.goal,
                    R.drawable.estrella,
                    R.drawable.hole
                )

                game!!.level = level4
                game!!.vibrator = mVibrator



                //DISEÑA  TU NIVEL AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                // Meta
                level4.setGoal(4, 4)

                // Limites
                level4.setTWallBlock(0, 0, 1, 32)
                level4.setTWallBlock(17, 0, 18, 32)
                level4.setTWallBlock(1, 0, 17, 1)
                level4.setTWallBlock(1, 31, 17, 32)


                // Paredes Horizontales
                //level4.setTWallBlock(9, 1, 14, 2)
                level4.setHole(1, 9)
                level4.setHole(1, 10)
                level4.setHole(1, 11)
                level4.setHole(1, 12)
                level4.setHole(1, 13)

                //level4.setTWallBlock(9, 4, 14, 5)
                level4.setHole(4, 9)
                level4.setHole(4, 10)
                level4.setHole(4, 11)
                level4.setHole(4, 12)
                level4.setHole(4, 13)

                //level4.setTWallBlock(3, 5, 10, 6)
                level4.setHole(5, 3)
                level4.setHole(5, 4)
                level4.setHole(5, 5)
                level4.setHole(5, 6)
                level4.setHole(5, 7)
                level4.setHole(5, 8)
                level4.setHole(5, 9)

                //level4.setTWallBlock(13, 8, 17, 9)
                level4.setHole(8, 13)
                level4.setHole(8, 14)
                level4.setHole(8, 15)
                level4.setHole(8, 16)

                //level4.setTWallBlock(6, 10, 11, 11)
                level4.setHole(10, 6)
                level4.setHole(10, 7)
                level4.setHole(10, 8)
                level4.setHole(10, 9)
                level4.setHole(10, 10)

                //level4.setTWallBlock(6, 14, 13, 15)
                level4.setHole(14, 6)
                level4.setHole(14, 7)
                level4.setHole(14, 8)
                level4.setHole(14, 9)
                level4.setHole(14, 10)
                level4.setHole(14, 11)
                level4.setHole(14, 12)

                //level4.setTWallBlock(1, 8, 2, 9)
                level4.setHole(8, 1)

                //level4.setTWallBlock(1, 17, 3, 18)
                level4.setHole(17, 1)
                level4.setHole(17, 2)

                //level4.setTWallBlock(12, 17, 17, 18)
                level4.setHole(17, 12)
                level4.setHole(17, 13)
                level4.setHole(17, 14)
                level4.setHole(17, 15)
                level4.setHole(17, 16)

                //level4.setTWallBlock(4, 24, 13, 25)
                level4.setHole(24, 4)
                level4.setHole(24, 5)
                level4.setHole(24, 6)
                level4.setHole(24, 7)
                level4.setHole(24, 8)
                level4.setHole(24, 9)
                level4.setHole(24, 10)
                level4.setHole(24, 11)
                level4.setHole(24, 12)

                //level4.setTWallBlock(6, 26, 9, 27)
                level4.setHole(26, 6)
                level4.setHole(26, 7)
                level4.setHole(26, 8)

                //level4.setTWallBlock(3, 28, 8, 29)
                level4.setHole(28, 3)
                level4.setHole(28, 4)
                level4.setHole(28, 5)
                level4.setHole(28, 6)
                level4.setHole(28, 7)

                //level4.setTWallBlock(10, 28, 15, 29)
                level4.setHole(28, 10)
                level4.setHole(28, 11)
                level4.setHole(28, 12)
                level4.setHole(28, 13)
                level4.setHole(28, 14)

                // Paredes Verticales
                //level4.setTWallBlock(3, 1, 4, 6)
                level4.setHole(1, 3)
                level4.setHole(2, 3)
                level4.setHole(3, 3)
                level4.setHole(4, 3)
                level4.setHole(5, 3)

                //level4.setTWallBlock(4, 1, 5, 2)
                level4.setHole(1, 4)

                //level4.setTWallBlock(5, 6, 6, 10)
                level4.setHole(6, 5)
                level4.setHole(7, 5)
                level4.setHole(8, 5)
                level4.setHole(9, 5)

                //level4.setTWallBlock(4, 7, 5, 8)
                level4.setHole(7, 4)

                //level4.setTWallBlock(4, 9, 5, 10)
                level4.setHole(9, 4)

                //level4.setTWallBlock(9, 11, 10, 12)
                level4.setHole(11, 9)

                //level4.setTWallBlock(3, 11, 4, 15)
                level4.setHole(11, 3)
                level4.setHole(12, 3)
                level4.setHole(13, 3)
                level4.setHole(14, 3)

                //level4.setTWallBlock(8, 14, 9, 18)
                level4.setHole(14, 8)
                level4.setHole(15, 8)
                level4.setHole(16, 8)
                level4.setHole(17, 8)

                //level4.setTWallBlock(4, 19, 5, 25)
                level4.setHole(19, 4)
                level4.setHole(20, 4)
                level4.setHole(21, 4)
                level4.setHole(22, 4)
                level4.setHole(23, 4)
                level4.setHole(24, 4)

                //level4.setTWallBlock(6, 25, 7, 26)
                level4.setHole(25, 6)

                //level4.setTWallBlock(12, 17, 13, 29)
                level4.setHole(17, 12)
                level4.setHole(18, 12)
                level4.setHole(19, 12)
                level4.setHole(20, 12)
                level4.setHole(21, 12)
                level4.setHole(22, 12)
                level4.setHole(23, 12)
                level4.setHole(24, 12)
                level4.setHole(25, 12)
                level4.setHole(26, 12)
                level4.setHole(27, 12)
                level4.setHole(28, 12)

                //level4.setTWallBlock(6, 11, 7, 14)
                level4.setHole(11, 6)
                level4.setHole(12, 6)
                level4.setHole(13, 6)

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

                level4.setBallStartPosAndSize(80f,80f)

            }
        })


    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
