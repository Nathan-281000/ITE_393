package com.example.ite393exam

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class EventActivity : AppCompatActivity() {
    private var userId : String? = null
    private var university : String? = null
    private var imageId : String? = null
    private lateinit var imageView : ImageView
    private val imageMap = mapOf(
        "2025-02-14" to R.drawable.fdc,
        "2025-06-01" to R.drawable.firstweekhi,
        "2025-07-15" to R.drawable.firstweekhitwo,
        "2025-07-19" to R.drawable.brigada,
        "2025-07-31" to R.drawable.nutrition,
        "2025-08-15" to R.drawable.buwanngwika,
        "2025-09-06" to R.drawable.eucharisticceleb,
        "2025-09-21" to R.drawable.citefest,
        "2025-10-03" to R.drawable.teachersandstaff,
        "2025-10-09" to R.drawable.leagueofleaders,
        "2025-11-31" to R.drawable.sportfest,
        "2025-12-03" to R.drawable.lamparaan,
        "2026-02-03" to R.drawable.eucharisticceleb,
        "2026-02-14" to R.drawable.fdc
    )
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event) // Ensure this XML file exists

        userId = intent.getStringExtra("studentId").toString()
        university = intent.getStringExtra("campus").toString()
        imageId = intent.getStringExtra("SELECTED_DATE").toString()
        val selectedDate = intent.getStringExtra("SELECTED_DATE")
        val eventDetails = intent.getStringExtra("EVENT_DETAILS")


        Toast.makeText(this, "Date $imageId", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Event $eventDetails", Toast.LENGTH_SHORT).show()


        imageView = findViewById(R.id.imageView)

        imageView.setImageResource(imageMap[imageId] ?: R.drawable.fdc)
        val textViewDate = findViewById<TextView>(R.id.textViewDate)
        val textViewEvents = findViewById<TextView>(R.id.textViewEvents)

        findViewById<Button>(R.id.back).setOnClickListener{
            val intent = Intent(this, HomePage::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        createNotificationChannel()
        showNotification(selectedDate ?: "No Date", eventDetails ?: "No Details")


        textViewDate.text = "Events for: $selectedDate"
        textViewEvents.text = eventDetails
    }
    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "id"
            val channelName = "channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = "This is my Description"
            }
            val notificationManager : NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    @SuppressLint("MissingPermission")
    private fun showNotification(date: String, details: String){
        val builder = NotificationCompat.Builder(this, "id")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentText(details)
            .setContentTitle(date)
            .setAutoCancel(true)
        with(NotificationManagerCompat.from(this)){
            notify(1, builder.build())
        }
    }
}
