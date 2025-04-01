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
    private var userId : String? = null
    private var university : String? = null
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

        btnFloor1.setOnClickListener {
            val intent =  Intent(this,firstFloor::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        btnFloor2.setOnClickListener {
            val intent =  Intent(this,secondFloor::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        btnFloor3.setOnClickListener {
            val intent =  Intent(this,thirdFloor::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        btnFloor4.setOnClickListener {
            val intent =  Intent(this,forthFloor::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        btnFloor5.setOnClickListener {
            val intent =  Intent(this,fifthFloor::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }

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
            val intent = Intent(this, Modules::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        maps.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
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
                val intent = Intent(this@Maps, HomePage::class.java)
                intent.putExtra("studentId", userId)
                intent.putExtra("campus", university)
                startActivity(intent)
                finish()
            }
        })
    }
}