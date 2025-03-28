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

class firstFloor : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ClickableViewAccessibility", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_floor)

        val rootLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.floorOne)
        val pass = Intent(this, Maps::class.java)
        val btnBack = findViewById<Button>(R.id.backBtn)
        val image = findViewById<ImageView>(R.id.imagePin)
        val roomBoard = findViewById<TextView>(R.id.roomBoard)
        val crBoys = findViewById<Button>(R.id.crBoys)
        val testingRoom = findViewById<Button>(R.id.testingRoom)
        val exit = findViewById<Button>(R.id.exit)
        val crGirl = findViewById<Button>(R.id.crGirl)
        val hydraulicsLab = findViewById<Button>(R.id.hydraulicsLab)
        val marketingDep = findViewById<Button>(R.id.marketingDep)
        val mainEntrance = findViewById<Button>(R.id.mainEntrance)
        val commercialSpace = findViewById<Button>(R.id.commercialSpace)
        val commercialSpaceTw0 = findViewById<Button>(R.id.commercialSpaceTw0)
        val canteen = findViewById<Button>(R.id.canteen)
        val incubationRm = findViewById<Button>(R.id.incubationRm)
        val isolationRm = findViewById<Button>(R.id.isolationRm)

        fun invisibleElem(){
            image.visibility = View.VISIBLE
            roomBoard.visibility = View.VISIBLE
            crBoys.visibility = View.INVISIBLE
            testingRoom.visibility = View.INVISIBLE
            exit.visibility = View.INVISIBLE
            crGirl.visibility = View.INVISIBLE
            hydraulicsLab.visibility = View.INVISIBLE
            marketingDep.visibility = View.INVISIBLE
            mainEntrance.visibility = View.INVISIBLE
            commercialSpace.visibility = View.INVISIBLE
            commercialSpaceTw0.visibility = View.INVISIBLE
            canteen.visibility = View.INVISIBLE
            incubationRm.visibility = View.INVISIBLE
            isolationRm.visibility = View.INVISIBLE
        }
        fun visibleElem(){
            crBoys.visibility = View.VISIBLE
            testingRoom.visibility = View.VISIBLE
            exit.visibility = View.VISIBLE
            crGirl.visibility = View.VISIBLE
            hydraulicsLab.visibility = View.VISIBLE
            marketingDep.visibility = View.VISIBLE
            mainEntrance.visibility = View.VISIBLE
            commercialSpace.visibility = View.VISIBLE
            commercialSpaceTw0.visibility = View.VISIBLE
            canteen.visibility = View.VISIBLE
            incubationRm.visibility = View.VISIBLE
            isolationRm.visibility = View.VISIBLE
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

        image.visibility = View.INVISIBLE

        btnBack.setOnClickListener{
            startActivity(pass)
        }
        crBoys.setOnClickListener {
            image.setImageResource(R.drawable.crboy)
            invisibleElem()
            roomBoard.text = "Comfort Room: Men"
            clickScreen()
        }
        crGirl.setOnClickListener{
            image.setImageResource(R.drawable.crgirl)
            invisibleElem()
            roomBoard.text = "Comfort Room: Women"
            clickScreen()
        }
        hydraulicsLab.setOnClickListener{
            image.setImageResource(R.drawable.hydraulicroom)
            invisibleElem()
            roomBoard.text = "Hydraulics Laboratory"
            clickScreen()
        }
        exit.setOnClickListener{
            image.setImageResource(R.drawable.exit)
            invisibleElem()
            roomBoard.text = "Exit"
            clickScreen()
        }
        testingRoom.setOnClickListener{
            image.setImageResource(R.drawable.testingroom)
            invisibleElem()
            roomBoard.text = "Testing Room"
            clickScreen()
        }
        marketingDep.setOnClickListener {
            image.setImageResource(R.drawable.putangainamomarketing)
            invisibleElem()
            roomBoard.text = "Marketing Department"
            clickScreen()
        }
        mainEntrance.setOnClickListener {
            image.setImageResource(R.drawable.mainentrance)
            invisibleElem()
            roomBoard.text = "Main Entrance"
            clickScreen()
        }
        commercialSpace.setOnClickListener {
            image.setImageResource(R.drawable.moduleroom)
            invisibleElem()
            roomBoard.text = "Commercial Space"
            clickScreen()
        }
        commercialSpaceTw0.setOnClickListener {
            image.setImageResource(R.drawable.anatomyroom)
            invisibleElem()
            roomBoard.text = "Commercial Space 2"
        }
        canteen.setOnClickListener {
            image.setImageResource(R.drawable.canteennam)
            invisibleElem()
            roomBoard.text = "Canteen"
            clickScreen()
        }
        incubationRm.setOnClickListener {
            image.setImageResource(R.drawable.meetingroom)
            invisibleElem()
            roomBoard.text = "Incubation Room"
            clickScreen()
        }
        isolationRm.setOnClickListener {
            image.setImageResource(R.drawable.moduleroom)
            invisibleElem()
            roomBoard.text = "Isolation Room"
            clickScreen()
        }
    }
}