package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class
Maps : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_maps)

        val btnFloor1 = findViewById<Button>(R.id.btnFloor1)
        val btnFloor2 = findViewById<Button>(R.id.btnFloor2)
        val btnFloor3 = findViewById<Button>(R.id.btnFloor3)
        val btnFloor4 = findViewById<Button>(R.id.btnFloor4)
        val btnFloor5 = findViewById<Button>(R.id.btnFloor5)
        val pass = Intent(this,HomePage ::class.java)
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

        val course = findViewById<ImageButton>(R.id.course)
        val modality = findViewById<ImageButton>(R.id.modules)
        val maps = findViewById<ImageButton>(R.id.maps)
        val profile = findViewById<ImageButton>(R.id.profile)
        course.setOnClickListener {
            val intent = Intent(this, Course::class.java)
            startActivity(intent)
            finish()
        }
        modality.setOnClickListener {
            val intent = Intent(this, Maps::class.java)
            startActivity(intent)
            finish()
        }
        maps.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()
        }
        profile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
            finish()
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                startActivity(pass)
            }
        })
    }
}