package com.example.ite393exam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class
maps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_maps)

        val btnFloor1 = findViewById<Button>(R.id.btnFloor1)
        val btnFloor2 = findViewById<Button>(R.id.btnFloor2)
        val btnFloor3 = findViewById<Button>(R.id.btnFloor3)
        val btnFloor4 = findViewById<Button>(R.id.btnFloor4)
        val btnFloor5 = findViewById<Button>(R.id.btnFloor5)
        val maps_button = findViewById<Button>(R.id.maps_button)
        val pass = Intent(this,Home_Page ::class.java)
        val intent =  Intent(this,firstFloor::class.java)
        val intent2 =  Intent(this,secondFloor::class.java)
        val intent3 =  Intent(this,thirdFloor::class.java)
        val intent4 =  Intent(this,forthFloor::class.java)
        val intent5 =  Intent(this,fifthFloor::class.java)

        btnFloor1.setOnClickListener {
            startActivity(intent)
        }
        btnFloor2.setOnClickListener {
            startActivity(intent2)
        }
        btnFloor3.setOnClickListener {
            startActivity(intent3)
        }
        btnFloor4.setOnClickListener {
            startActivity(intent4)
        }
        btnFloor5.setOnClickListener {
            startActivity(intent5)
        }
        maps_button.setOnClickListener {
            //startActivity(pass)
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                startActivity(pass)
            }
        })
    }
}