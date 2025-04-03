package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AskMe : AppCompatActivity() {
    private var userId : String? = null
    private var university : String? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ask_me)
        userId = intent.getStringExtra("studentId").toString()
        university = intent.getStringExtra("campus").toString()
        val providedCourses = findViewById<TextView>(R.id.providedCourses)
        val whyChoose = findViewById<TextView>(R.id.whyChoose)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val howToEnroll = findViewById<TextView>(R.id.howtoEnroll)
        val scholarship = findViewById<TextView>(R.id.scholarship)
        val back = findViewById<TextView>(R.id.back)
        val qualityOfEducation = findViewById<TextView>(R.id.qualityOfEducation)
        providedCourses.setOnClickListener {
            textView3.setText(R.string.courses)
        }
        whyChoose.setOnClickListener {
            textView3.setText(R.string.enroll)
        }
        howToEnroll.setOnClickListener {
            textView3.setText(R.string.enrollment)
        }
        scholarship.setOnClickListener {
            textView3.setText(R.string.scholarship)
        }
        qualityOfEducation.setOnClickListener {
            textView3.setText(R.string.qualityOfEducation)
        }
        back.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val intent = Intent(this@AskMe, HomePage::class.java)
                intent.putExtra("studentId", userId)
                intent.putExtra("campus", university)
                startActivity(intent)
                finish()
            }
        })
    }
}