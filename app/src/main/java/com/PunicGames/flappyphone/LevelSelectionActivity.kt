package com.PunicGames.flappyphone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class LevelSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        setContentView(R.layout.level_selection_layout)
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        var context = this

        var back : Button = findViewById(R.id.back_button)
        back.setOnClickListener {
            val intent = Intent(context, MainMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        var lvl1 : Button = findViewById(R.id.lvl1_button)
        lvl1.setOnClickListener {
            val intent = Intent(context, Level_1_Activity::class.java)
            startActivity(intent)
            finish()
        }
        var lvl2 : Button = findViewById(R.id.lvl2_button)
        lvl2.setOnClickListener {
            val intent = Intent(context, Level_2_Activity::class.java)
            startActivity(intent)
            finish()
        }
        var lvl3 : Button = findViewById(R.id.lvl3_button)
        lvl3.setOnClickListener {
            val intent = Intent(context, Level_3_Activity::class.java)
            startActivity(intent)
            finish()
        }
        var lvl4 : Button = findViewById(R.id.lvl4_button)
        lvl4.setOnClickListener {

            val intent = Intent(context, Level_4_Activity::class.java)

            startActivity(intent)
            finish()
        }
    }
}