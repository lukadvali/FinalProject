package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var playbutton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playbutton = findViewById(R.id.playbutton)

        playbutton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java )
            startActivity(intent)
        }
    }
}