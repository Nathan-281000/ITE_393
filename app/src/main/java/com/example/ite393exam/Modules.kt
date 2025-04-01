package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Modules : AppCompatActivity() {
    private var userId : String? = null
    private var university : String? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_modules)

        userId = intent.getStringExtra("studentId").toString()
        university = intent.getStringExtra("campus").toString()
        val course = findViewById<ImageButton>(R.id.coursebtn)
        val modality = findViewById<ImageButton>(R.id.modules)
        val maps = findViewById<ImageButton>(R.id.maps)
        val profile = findViewById<ImageButton>(R.id.profile)
        course.setOnClickListener {
            val intent = Intent(this, Course::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        modality.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
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
                val intent = Intent(this@Modules, HomePage::class.java)
                intent.putExtra("studentId", userId)
                intent.putExtra("campus", university)
                startActivity(intent)
                finish()
            }

        })
    }
}