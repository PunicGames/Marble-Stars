package com.PunicGames.flappyphone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LevelSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.level_selection)
        var context = this

        var back : Button = findViewById(R.id.back_button)
        back.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        var lvl1 : Button = findViewById(R.id.lvl1_button)
        lvl1.setOnClickListener {
            val intent = Intent(context, GravityActivity::class.java)
            startActivity(intent)
            finish()
        }
        var lvl2 : Button = findViewById(R.id.lvl2_button)
        lvl2.setOnClickListener {
            val intent = Intent(context, TestCellsActivity::class.java)
            startActivity(intent)
            finish()
        }
        var lvl3 : Button = findViewById(R.id.lvl3_button)
        lvl3.setOnClickListener {
            //val intent = Intent(context, GravityActivity::class.java)
            //startActivity(intent)
            //finish()
        }
        var lvl4 : Button = findViewById(R.id.lvl4_button)
        lvl4.setOnClickListener {
            //val intent = Intent(context, TestCellsActivity::class.java)
            //startActivity(intent)
            //finish()
        }
    }
}