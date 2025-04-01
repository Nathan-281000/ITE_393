package com.example.ite393exam

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Course : AppCompatActivity() {
    private lateinit var userId : String
    private lateinit var university : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_course)
        val course = findViewById<ImageButton>(R.id.coursebtn)
        val modality = findViewById<ImageButton>(R.id.modules)
        val maps = findViewById<ImageButton>(R.id.maps)
        val profile = findViewById<ImageButton>(R.id.profile)

        userId = intent.getStringExtra("studentId").toString()
        university = intent.getStringExtra("campus").toString()
        course.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        modality.setOnClickListener {
            val intent = Intent(this, Modules::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        maps.setOnClickListener {
            val intent = Intent(this, Maps::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        profile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val intent = Intent(this@Course, HomePage::class.java)
                intent.putExtra("studentId", userId)
                intent.putExtra("campus", university)
                startActivity(intent)
                finish()
            }

        })


    }

}