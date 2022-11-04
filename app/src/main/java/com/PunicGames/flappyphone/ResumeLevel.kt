package com.PunicGames.flappyphone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResumeLevel : AppCompatActivity() {

    lateinit var exitButton: Button
    lateinit var pointText: TextView
    lateinit var minuteText: TextView
    lateinit var secondsText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level_resume_layout)

        var bundle = intent.extras
        var puntos = bundle?.getInt("points");
        var minutos = bundle?.getInt("minutes");
        var segundos = bundle?.getInt("seconds");

        exitButton = findViewById(R.id.salir)
        exitButton!!.setOnClickListener {
            var intent = Intent(this, LevelSelectionActivity::class.java)
            startActivity(intent)
        }


        pointText = findViewById(R.id.puntos)
        minuteText = findViewById(R.id.minutos)
        secondsText = findViewById(R.id.segundos)

        pointText.text = puntos.toString() + " estrellas"
        minuteText.text = minutos.toString() + " minutos"
        secondsText.text = segundos.toString() + " segundos"

    }
}