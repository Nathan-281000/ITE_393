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

class secondFloor : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ClickableViewAccessibility", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_floor)

        val rootLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        val pass = Intent(this, Maps::class.java)
        val btnBack2 = findViewById<Button>(R.id.backBtn)
        val image = findViewById<ImageView>(R.id.imagePin)
        val roomBoard  = findViewById<TextView>(R.id.roomBoard)
        val btnCRBoys = findViewById<Button>(R.id.crBoys)
        val btnRoom203 = findViewById<Button>(R.id.room203)
        val btnRoom204 = findViewById<Button>(R.id.room204)
        val btnClinic = findViewById<Button>(R.id.clinic)
        val btnRoom202 = findViewById<Button>(R.id.room202)
        val btnRoom201 = findViewById<Button>(R.id.room201)
        val btnRoom205 = findViewById<Button>(R.id.room205)
        val btnRoom206 = findViewById<Button>(R.id.room206)
        val btnRegistrarFinance = findViewById<Button>(R.id.registrarFinance)
        val btnAdminOffice = findViewById<Button>(R.id.adminOffice)

        fun invisibleElem(){
            image.visibility = View.VISIBLE
            roomBoard.visibility = View.VISIBLE
            btnCRBoys.visibility = View.INVISIBLE
            btnRoom203.visibility = View.INVISIBLE
            btnRoom204.visibility = View.INVISIBLE
            btnClinic.visibility = View.INVISIBLE
            btnRoom202.visibility = View.INVISIBLE
            btnRoom201.visibility = View.INVISIBLE
            btnRoom205.visibility = View.INVISIBLE
            btnRoom206.visibility = View.INVISIBLE
            btnRegistrarFinance.visibility = View.INVISIBLE
            btnAdminOffice.visibility = View.INVISIBLE
        }

        fun visibleElem(){
            btnCRBoys.visibility = View.VISIBLE
            btnRoom203.visibility = View.VISIBLE
            btnRoom204.visibility = View.VISIBLE
            btnClinic.visibility = View.VISIBLE
            btnRoom202.visibility = View.VISIBLE
            btnRoom201.visibility = View.VISIBLE
            btnRoom205.visibility = View.VISIBLE
            btnRoom206.visibility = View.VISIBLE
            btnRegistrarFinance.visibility = View.VISIBLE
            btnAdminOffice.visibility = View.VISIBLE
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

        btnBack2.setOnClickListener{
            startActivity(pass)
        }
        btnCRBoys.setOnClickListener{
            image.setImageResource(R.drawable.crsecondboy)
            invisibleElem()
            roomBoard.text = "CR Boys Room"
            clickScreen()
        }
        btnRoom203.setOnClickListener{
            image.setImageResource(R.drawable.room203)
            invisibleElem()
            roomBoard.text = "Room 203"
            clickScreen()
        }
        btnRoom204.setOnClickListener{
            image.setImageResource(R.drawable.room204)
            invisibleElem()
            roomBoard.text = "Room 204"
            clickScreen()
        }
        btnClinic.setOnClickListener{
            image.setImageResource(R.drawable.clinic)
            invisibleElem()
            roomBoard.text = "Clinic"
            clickScreen()
        }
        btnRoom202.setOnClickListener{
            image.setImageResource(R.drawable.room202)
            invisibleElem()
            roomBoard.text = "Room 202"
            clickScreen()
        }
        btnRoom201.setOnClickListener{
            image.setImageResource(R.drawable.room201)
            invisibleElem()
            roomBoard.text = "Room 201"
            clickScreen()
        }
        btnRoom205.setOnClickListener{
            image.setImageResource(R.drawable.room205)
            invisibleElem()
            roomBoard.text = "Room 205"
            clickScreen()
        }
        btnRoom206.setOnClickListener{
            image.setImageResource(R.drawable.room206)
            invisibleElem()
            roomBoard.text = "Room 206"
            clickScreen()
        }
        btnRegistrarFinance.setOnClickListener{
            image.setImageResource(R.drawable.financeregistrar)
            invisibleElem()
            roomBoard.text = "Registrar and Finance"
            clickScreen()
        }
        btnAdminOffice.setOnClickListener{
            image.setImageResource(R.drawable.center)
            invisibleElem()
            roomBoard.text = "Admin Office"
            clickScreen()
        }


    }
}