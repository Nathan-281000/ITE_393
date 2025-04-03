package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import android.widget.VideoView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class Market : AppCompatActivity() {
    private var userId : String? = null
    private var university : String? = null
    private lateinit var scrollView4 : ScrollView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        userId = intent.getStringExtra("studentId").toString()
        university = intent.getStringExtra("campus").toString()
        setContentView(R.layout.activity_market)
        val back = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.back)
        val videoView = findViewById<VideoView>(R.id.videoView)
        val videoView2 = findViewById<VideoView>(R.id.videoView2)
        scrollView4 = findViewById<ScrollView>(R.id.scrollView4)
        val videoUri : Uri = ("android.resource://" + packageName + "/" + R.raw.education).toUri()
        videoView.setVideoURI(videoUri)
        val videoUri2 : Uri = ("android.resource://" + packageName + "/" + R.raw.lolo).toUri()
        videoView2.setVideoURI(videoUri2)
        videoView.isFocusable = false
        videoView2.isFocusable = false

        // AutoPlay
        fun View.isVisibleInScrollView(scrollView: ScrollView): Boolean {
            val scrollBounds = Rect()
            scrollView.getHitRect(scrollBounds)
            return getLocalVisibleRect(scrollBounds)
        }

        // Playing
        scrollView4.viewTreeObserver.addOnScrollChangedListener {
            if (videoView.isVisibleInScrollView(scrollView4)) {
                if (!videoView.isPlaying) {
                    videoView.start()
                }
            } else {
                if (videoView.isPlaying) {
                    videoView.pause()
                }
            }

            if (videoView2.isVisibleInScrollView(scrollView4)) {
                if (!videoView2.isPlaying) {
                    videoView2.start()
                }
            } else {
                if (videoView2.isPlaying) {
                    videoView2.pause()
                }
            }
            back.setOnClickListener {
                val intent = Intent(this@Market, HomePage::class.java)
                intent.putExtra("studentId", userId)
                intent.putExtra("campus", university)
                startActivity(intent)
                finish()
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val intent = Intent(this@Market, HomePage::class.java)
                intent.putExtra("studentId", userId)
                intent.putExtra("campus", university)
                startActivity(intent)
                finish()
            }
        })

    }
    override fun onResume() {
        super.onResume()
        scrollView4.post { scrollView4.fullScroll(ScrollView.FOCUS_UP) }
    }
}