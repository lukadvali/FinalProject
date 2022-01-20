package com.example.myfirstapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var button5 : Button
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var button8 : Button
    private lateinit var button9 : Button
    private lateinit var button10 : Button
    private lateinit var button11 : Button
    private lateinit var button12 : Button
    private lateinit var button13 : Button
    private lateinit var button14 : Button
    private lateinit var button15 : Button
    private lateinit var button16 : Button
    private lateinit var points : TextView
    private var pts = points.text.toString().toInt()
    private var numClicked = 0
    private val totalButtons = 16
    var buttons = arrayListOf<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
    }

    private fun init(){
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button10 = findViewById(R.id.button10)
        button11 = findViewById(R.id.button11)
        button12 = findViewById(R.id.button12)
        button13 = findViewById(R.id.button13)
        button14 = findViewById(R.id.button14)
        button15 = findViewById(R.id.button15)
        button16 = findViewById(R.id.button16)
        points = findViewById(R.id.points)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        button10.setOnClickListener(this)
        button11.setOnClickListener(this)
        button12.setOnClickListener(this)
        button13.setOnClickListener(this)
        button14.setOnClickListener(this)
        button15.setOnClickListener(this)
        button16.setOnClickListener(this)

        buttons.addAll(
            listOf(button1,button2,button3,button4,button5,button6,button7,button8,
                button9,button10,button11,button12,button13,button14,button15,button16)
        )
    }
    //var pts = points.text.toString()

    private fun playGame(clickedView: Button, randomNumber: Int){
        clickedView.text = randomNumber.toString()
        clickedView.isEnabled = false
        if(randomNumber == 0){
            for(button in buttons){
                button.isEnabled = true
                button.text = ""
            }
            val toPass = pts
            pts = 0
            points.text = pts.toString()
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("POINTS", toPass.toString())
            startActivity(intent)
        } else {
            pts += randomNumber
            points.text = pts.toString()
            if(numClicked == totalButtons) {
                for(button in buttons){
                    button.isEnabled = true
                    button.text = ""
                }
                val toPass = pts
                pts = 0
                points.text = pts.toString()
                val intent = Intent(this,MainActivity3::class.java)
                intent.putExtra("POINTS",toPass.toString())
                startActivity(intent)
            }
        }
    }

    override fun onClick(clickedView: View?) {
        if(clickedView is Button){
            val randomNumber = Random.nextInt(10)
            numClicked += 1
            playGame(clickedView, randomNumber)
        }
    }
}
