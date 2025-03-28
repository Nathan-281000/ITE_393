package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EventActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event) // Ensure this XML file exists
        findViewById<Button>(R.id.back).setOnClickListener{
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()
        }


        val selectedDate = intent.getStringExtra("SELECTED_DATE")
        val eventDetails = intent.getStringExtra("EVENT_DETAILS")


        val textViewDate = findViewById<TextView>(R.id.textViewDate)
        val textViewEvents = findViewById<TextView>(R.id.textViewEvents)


        textViewDate.text = "Events for: $selectedDate"
        textViewEvents.text = eventDetails
    }
}
