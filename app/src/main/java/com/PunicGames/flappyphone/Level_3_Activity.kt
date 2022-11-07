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


class Level_3_Activity : Level_Activity() {

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
                var level3: Level = Level(
                    game!!,
                    game!!.width,
                    game!!.height,
                    R.drawable.background,
                    R.drawable.woodwall,
                    R.drawable.goal,
                    R.drawable.estrella,
                    R.drawable.hole
                )

                game!!.level = level3
                game!!.vibrator = mVibrator
                //level3.debug=true


                //DISEÑA  TU NIVEL AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                // Meta
                level3.setGoal(29, 15)

                // Limites
                level3.setTWallBlock(0, 0, 1, 32)
                level3.setTWallBlock(17, 0, 18, 32)
                level3.setTWallBlock(1, 0, 17, 1)
                level3.setTWallBlock(1, 31, 17, 32)


                // Paredes Horizontales
                level3.setTWallBlock(1, 6, 4, 7)
                level3.setTWallBlock(10, 4, 15, 5)
                level3.setTWallBlock(14, 8, 17, 9)
                level3.setTWallBlock(4, 10, 13, 11)
                level3.setTWallBlock(10, 12, 13, 13)
                level3.setTWallBlock(1, 14, 4, 15)
                level3.setTWallBlock(8, 19, 17, 20)
                level3.setTWallBlock(10, 22, 14, 23)
                level3.setTWallBlock(13, 23, 17, 24)
                level3.setTWallBlock(5, 28, 11, 29)

                // Paredes Verticales
                level3.setTWallBlock(6, 1, 7, 7)
                level3.setTWallBlock(9, 4, 10, 10)
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

                level3.setBallStartPosAndSize(200f, 200f)


            }
        })


    }

    override fun onDestroy() {
        super.onDestroy()

    }
}
