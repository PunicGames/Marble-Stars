package com.PunicGames.flappyphone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceView
import android.widget.Button


class LVL2_test_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level2_layout)

        //var s_view : SurfaceView = findViewById(R.id.surfaceView)
        //s_view.holder.addCallback(this)

        //s_view.isFocusable











        var back : Button = findViewById(R.id.back_button)
        var context = this
        back.setOnClickListener {
            //val intent = Intent(context, GravityActivity::class.java)
            //val intent = Intent(context, TestCellsActivity::class.java)
            val intent = Intent(context, LevelSelectionActivity::class.java)
            startActivity(intent)
            finish()
        }


    }


}


