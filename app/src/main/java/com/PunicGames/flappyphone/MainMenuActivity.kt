package com.PunicGames.flappyphone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        var btn : Button = findViewById(R.id.mainButton)
        var context = this
        btn.setOnClickListener {
            //val intent = Intent(context, GravityActivity::class.java)
            //val intent = Intent(context, TestCellsActivity::class.java)
            val intent = Intent(context, LevelSelectionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}