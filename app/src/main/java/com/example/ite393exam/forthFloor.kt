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

class forthFloor : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ClickableViewAccessibility", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forth_floor)

        val pass = Intent(this, maps::class.java)
        val btnBack = findViewById<Button>(R.id.backBtn)
        val rootLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        val image = findViewById<ImageView>(R.id.imagePin)
        val roomBoard  = findViewById<TextView>(R.id.roomBoard)
        val btnCrBoys = findViewById<Button>(R.id.crBoys)
        val btnRoom403 = findViewById<Button>(R.id.room403)
        val btnRoom404 = findViewById<Button>(R.id.room404)
        val btnCrGirl = findViewById<Button>(R.id.crGirl)
        val btnRoom402 = findViewById<Button>(R.id.room402)
        val btnRoom401 = findViewById<Button>(R.id.room401)
        val btnChemistryLab = findViewById<Button>(R.id.chemistryLab)
        val btnPhysicsLab = findViewById<Button>(R.id.physicsLab)
        val btnSeniorHighDep = findViewById<Button>(R.id.seniorHighDep)
        val btnTertiaryDep = findViewById<Button>(R.id.tertiaryDep)

        fun invisibleElem(){
            image.visibility = View.VISIBLE
            roomBoard.visibility = View.VISIBLE
            btnCrBoys.visibility = View.INVISIBLE
            btnRoom403.visibility = View.INVISIBLE
            btnRoom404.visibility = View.INVISIBLE
            btnCrGirl.visibility = View.INVISIBLE
            btnRoom402.visibility = View.INVISIBLE
            btnRoom401.visibility = View.INVISIBLE
            btnChemistryLab.visibility = View.INVISIBLE
            btnPhysicsLab.visibility = View.INVISIBLE
            btnSeniorHighDep.visibility = View.INVISIBLE
            btnTertiaryDep.visibility = View.INVISIBLE
        }

        fun visibleElem(){
            btnCrBoys.visibility = View.VISIBLE
            btnRoom403.visibility = View.VISIBLE
            btnRoom404.visibility = View.VISIBLE
            btnCrGirl.visibility = View.VISIBLE
            btnRoom402.visibility = View.VISIBLE
            btnRoom401.visibility = View.VISIBLE
            btnChemistryLab.visibility = View.VISIBLE
            btnPhysicsLab.visibility = View.VISIBLE
            btnSeniorHighDep.visibility = View.VISIBLE
            btnTertiaryDep.visibility = View.VISIBLE
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
        btnCrBoys.setOnClickListener {
            image.setImageResource(R.drawable.crfourboy)
            invisibleElem()
            roomBoard.text = "CR Boys Room"
            clickScreen()
        }
        btnRoom403.setOnClickListener {
            image.setImageResource(R.drawable.room403)
            invisibleElem()
            roomBoard.text = "Room 403"
            clickScreen()
        }
        btnRoom404.setOnClickListener {
            image.setImageResource(R.drawable.room404)
            invisibleElem()
            roomBoard.text = "Room 404"
            clickScreen()
        }
        btnCrGirl.setOnClickListener {
            image.setImageResource(R.drawable.crfourgirl)
            invisibleElem()
            roomBoard.text = "CR Girls Room"
            clickScreen()
        }
        btnRoom402.setOnClickListener {
            image.setImageResource(R.drawable.room402)
            invisibleElem()
            roomBoard.text = "Room 402"
            clickScreen()
        }
        btnRoom401.setOnClickListener {
            image.setImageResource(R.drawable.room401)
            invisibleElem()
            roomBoard.text = "Room 401"
            clickScreen()
        }
        btnChemistryLab.setOnClickListener {
            image.setImageResource(R.drawable.chemistrylaboratory)
            invisibleElem()
            roomBoard.text = "Chemistry Lab"
            clickScreen()
        }
        btnPhysicsLab.setOnClickListener {
            image.setImageResource(R.drawable.room406)
            invisibleElem()
            roomBoard.text = "Physics Lab"
            clickScreen()
        }
        btnSeniorHighDep.setOnClickListener {
            image.setImageResource(R.drawable.seniorhighdepartment)
            invisibleElem()
            roomBoard.text = "Senior High Department"
            clickScreen()
        }
        btnTertiaryDep.setOnClickListener {
            image.setImageResource(R.drawable.collegedepartment)
            invisibleElem()
            roomBoard.text = "Tertiary Department"
            clickScreen()
        }
    }
}