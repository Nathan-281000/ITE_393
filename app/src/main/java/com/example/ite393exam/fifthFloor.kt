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

class fifthFloor : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ClickableViewAccessibility", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fifth_floor)

        val pass = Intent(this, Maps::class.java)
        val btnBack = findViewById<Button>(R.id.backBtn)
        val rootLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        val image = findViewById<ImageView>(R.id.imagePin)
        val roomBoard  = findViewById<TextView>(R.id.roomBoard)
        val btnCrBoysGirls = findViewById<Button>(R.id.crBoys)
        val btnStudioLab = findViewById<Button>(R.id.studioLab)
        val btnCrimeLab = findViewById<Button>(R.id.crimeLab)
        val btnDarkRoom = findViewById<Button>(R.id.crGirl)
        val btnKitchenLab = findViewById<Button>(R.id.kitchenLab)
        val btnDrawingLab = findViewById<Button>(R.id.drawingLab)
        val btnRoom505 = findViewById<Button>(R.id.room505)
        val btnRoom506 = findViewById<Button>(R.id.room506)
        val btnLibrary = findViewById<Button>(R.id.library)

        fun invisibleElem(){
            image.visibility = View.VISIBLE
            roomBoard.visibility = View.VISIBLE
            btnCrBoysGirls.visibility = View.INVISIBLE
            btnStudioLab.visibility = View.INVISIBLE
            btnCrimeLab.visibility = View.INVISIBLE
            btnKitchenLab.visibility = View.INVISIBLE
            btnDrawingLab.visibility = View.INVISIBLE
            btnRoom505.visibility = View.INVISIBLE
            btnRoom506.visibility = View.INVISIBLE
            btnLibrary.visibility = View.INVISIBLE
        }

        fun visibleElem(){
            btnCrBoysGirls.visibility = View.VISIBLE
            btnStudioLab.visibility = View.VISIBLE
            btnCrimeLab.visibility = View.VISIBLE
            btnKitchenLab.visibility = View.VISIBLE
            btnDrawingLab.visibility = View.VISIBLE
            btnRoom505.visibility = View.VISIBLE
            btnRoom506.visibility = View.VISIBLE
            btnLibrary.visibility = View.VISIBLE
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


        btnBack.setOnClickListener{
            startActivity(pass)
        }
        btnCrBoysGirls.setOnClickListener {
            image.setImageResource(R.drawable.crfourboy)
            invisibleElem()
            roomBoard.text = "CR Boys and Girls Room"
            clickScreen()
        }
        btnStudioLab.setOnClickListener {
            image.setImageResource(R.drawable.crimesceneroom)
            invisibleElem()
            roomBoard.text = "Studio Lab"
            clickScreen()
        }
        btnCrimeLab.setOnClickListener {
            image.setImageResource(R.drawable.criminilogylaboratory)
            invisibleElem()
            roomBoard.text = "Crime Lab"
            clickScreen()
        }
        btnDarkRoom.setOnClickListener {
            image.setImageResource(R.drawable.darkroom)
            invisibleElem()
            roomBoard.text = "Dark Room"
            clickScreen()
        }
        btnKitchenLab.setOnClickListener {
            image.setImageResource(R.drawable.room501)
            invisibleElem()
            roomBoard.text = "Kitchen Lab"
            clickScreen()
        }
        btnDrawingLab.setOnClickListener {
            image.setImageResource(R.drawable.drawinglab)
            invisibleElem()
            roomBoard.text = "Drawing Lab"
            clickScreen()
        }
        btnRoom505.setOnClickListener {
            image.setImageResource(R.drawable.mootroom)
            invisibleElem()
            roomBoard.text = "Room 505"
            clickScreen()
        }
        btnRoom506.setOnClickListener {
            image.setImageResource(R.drawable.room506)
            invisibleElem()
            roomBoard.text = "Room 506"
            clickScreen()
        }
        btnLibrary.setOnClickListener {
            image.setImageResource(R.drawable.library)
            invisibleElem()
            roomBoard.text = "Library"
            clickScreen()
        }

    }
}