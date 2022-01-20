package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    lateinit var score : TextView
    lateinit var playagain : Button
    lateinit var menubutton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        playagain = findViewById(R.id.playagain)
        menubutton = findViewById(R.id.menubutton)
        score = findViewById(R.id.score)
        score.text = intent?.extras?.getString("POINTS")

        menubutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        playagain.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}