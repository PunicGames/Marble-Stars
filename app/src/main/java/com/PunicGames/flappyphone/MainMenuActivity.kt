package com.PunicGames.flappyphone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.main_menu_level)

        var btn : Button = findViewById(R.id.mainButton)
        var context = this
        btn.setOnClickListener {
            val intent = Intent(context, ComposeLevelSelectionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}