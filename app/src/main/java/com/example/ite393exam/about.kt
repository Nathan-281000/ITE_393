package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class about : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnback = findViewById<Button>(R.id.aboutbck)
        val intention = Intent(this, HomePage::class.java)
        val pass = Intent(this, student_manual::class.java)

        findViewById<Button>(R.id.manual).setOnClickListener {
            startActivity(pass)
            finish()
        }


        val linkTomaps: TextView = findViewById(R.id.maps)
        val linkTomaps_2: TextView = findViewById(R.id.maps_2)

        linkTomaps.setOnClickListener {
            val uri = "geo:15.9698,120.5722?q=XH9C+WV4,+MacArthur+Hwy,+Urdaneta,+Pangasinan".toUri()

            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
        btnback.setOnClickListener{
            startActivity(intention)
        }

        linkTomaps_2.setOnClickListener {
            val uri =
                "geo:16.0471,120.3425?q=28WV+R2R,+Arellano+St,+Downtown+District,+Dagupan,+Pangasinan".toUri()


            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                startActivity(intention)
            }
        })
    }
}
