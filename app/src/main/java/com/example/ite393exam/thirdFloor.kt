package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class thirdFloor : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ClickableViewAccessibility", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third_floor)

        val rootLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        val pass = Intent(this, maps::class.java)
        val btnBack3 = findViewById<Button>(R.id.backBtn)
        val image = findViewById<ImageView>(R.id.imagePin)
        val roomBoard  = findViewById<TextView>(R.id.roomBoard)
        val btnCRBoys = findViewById<Button>(R.id.crBoys)
        val btnRoom303 = findViewById<Button>(R.id.room303)
        val btnRoom304 = findViewById<Button>(R.id.room304)
        val btnCRGirl = findViewById<Button>(R.id.crGirl)
        val btnRoom302 = findViewById<Button>(R.id.room302)
        val btnRoom301 = findViewById<Button>(R.id.room301)
        val btnRoom305 = findViewById<Button>(R.id.room305)
        val btnRoom306 = findViewById<Button>(R.id.room306)
        val btnComLab = findViewById<Button>(R.id.comLab)
        val btnMacLab = findViewById<Button>(R.id.macLab)

        fun invisibleElem(){
            image.visibility = View.VISIBLE
            roomBoard.visibility = View.VISIBLE
            btnCRBoys.visibility = View.INVISIBLE
            btnRoom303.visibility = View.INVISIBLE
            btnRoom304.visibility = View.INVISIBLE
            btnCRGirl.visibility = View.INVISIBLE
            btnRoom302.visibility = View.INVISIBLE
            btnRoom301.visibility = View.INVISIBLE
            btnRoom305.visibility = View.INVISIBLE
            btnRoom306.visibility = View.INVISIBLE
            btnComLab.visibility = View.INVISIBLE
            btnMacLab.visibility = View.INVISIBLE
        }

        fun visibleElem(){
            btnCRBoys.visibility = View.VISIBLE
            btnRoom303.visibility = View.VISIBLE
            btnRoom304.visibility = View.VISIBLE
            btnCRGirl.visibility = View.VISIBLE
            btnRoom302.visibility = View.VISIBLE
            btnRoom301.visibility = View.VISIBLE
            btnRoom305.visibility = View.VISIBLE
            btnRoom306.visibility = View.VISIBLE
            btnComLab.visibility = View.VISIBLE
            btnMacLab.visibility = View.VISIBLE
            roomBoard.visibility = View.INVISIBLE
        }

        fun clickScreen(){
            rootLayout.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    // Do something when the screen is clicked
                    image.visibility = View.INVISIBLE
                    visibleElem()
                }
                false // Return false if you want to allow other events to be processed
            }
        }

        btnBack3.setOnClickListener{
            startActivity(pass)
        }
        btnCRBoys.setOnClickListener {
            image.setImageResource(R.drawable.crthirdboy)
            invisibleElem()
            roomBoard.text = "CR Boys Room"
            clickScreen()
        }
        btnRoom303.setOnClickListener {
            image.setImageResource(R.drawable.room303)
            invisibleElem()
            roomBoard.text = "Room 303"
            clickScreen()
        }
        btnRoom304.setOnClickListener {
            image.setImageResource(R.drawable.room304)
            invisibleElem()
            roomBoard.text = "Room 304"
            clickScreen()
        }
        btnCRGirl.setOnClickListener {
            image.setImageResource(R.drawable.crthirdgirl)
            invisibleElem()
            roomBoard.text = "CR Girls Room"
            clickScreen()
        }
        btnRoom302.setOnClickListener {
            image.setImageResource(R.drawable.room302)
            invisibleElem()
            roomBoard.text = "Room 302"
            clickScreen()
        }
        btnRoom301.setOnClickListener {
            image.setImageResource(R.drawable.room301)
            invisibleElem()
            roomBoard.text = "Room 301"
            clickScreen()
        }
        btnRoom305.setOnClickListener {
            image.setImageResource(R.drawable.room305)
            invisibleElem()
            roomBoard.text = "Room 305"
            clickScreen()
        }
        btnRoom306.setOnClickListener {
            image.setImageResource(R.drawable.room306)
            invisibleElem()
            roomBoard.text = "Room 306"
            clickScreen()
        }
        btnMacLab.setOnClickListener {
            image.setImageResource(R.drawable.room308)
            invisibleElem()
            roomBoard.text = "Mac Lab"
            clickScreen()
        }
        btnComLab.setOnClickListener {
            image.setImageResource(R.drawable.room307)
            invisibleElem()
            roomBoard.text = "Com Lab"
            clickScreen()
        }
    }
}