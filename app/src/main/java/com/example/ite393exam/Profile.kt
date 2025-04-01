package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class Profile : AppCompatActivity() {
    private var db = Firebase.firestore
    private lateinit var userId : String
    private lateinit var university : String
    private lateinit var password : String
    private lateinit var stuId : TextView
    private lateinit var attendingUniversity : TextView
    private lateinit var college : TextView
    private lateinit var degreeCourse : TextView
    private lateinit var stuName : TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        userId = intent.getStringExtra("studentId").toString()
        university = intent.getStringExtra("campus").toString()
        password = intent.getStringExtra("password").toString()

        Toast.makeText(this, "Welcome $userId", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Welcome to $university", Toast.LENGTH_SHORT).show()

        stuId = findViewById<TextView>(R.id.stuID)
        stuId.text = userId
        attendingUniversity = findViewById<TextView>(R.id.attendingCampus)
        college = findViewById<TextView>(R.id.collegeDep)
        degreeCourse = findViewById<TextView>(R.id.degreeCourse)
        stuName = findViewById<TextView>(R.id.stuName)
        val ref = db.collection(university).document(userId)
        ref.get().addOnSuccessListener {
            if (it.exists()){
                val firstName = it.getString("firstName")
                val lastName = it.getString("lastName")
                val middleName = it.getString("middleName")
                val course = it.getString("course")
                val stuUniversity = it.getString("university")
                val stuCollege = it.getString("college")
                stuName.text = "$firstName $middleName $lastName"
                attendingUniversity.text = stuUniversity
                college.text = stuCollege
                degreeCourse.text = course
            }
            else{
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }
        }

        val course = findViewById<ImageButton>(R.id.coursebtn)
        val modality = findViewById<ImageButton>(R.id.modules)
        val maps = findViewById<ImageButton>(R.id.maps)
        val profile = findViewById<ImageButton>(R.id.profile)
        course.setOnClickListener {
            val intent = Intent(this, Course::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            intent.putExtra("password", password)
            startActivity(intent)
            finish()
        }
        modality.setOnClickListener {
            val intent = Intent(this, Modules::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            intent.putExtra("password", password)
            startActivity(intent)
            finish()
        }
        maps.setOnClickListener {
            val intent = Intent(this, Maps::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            intent.putExtra("password", password)
            startActivity(intent)
            finish()
        }
        profile.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            intent.putExtra("password", password)
            startActivity(intent)
            finish()
        }

        val editProf = findViewById<Button>(R.id.editProf)
        val viewProf = findViewById<Button>(R.id.viewProf)
        val logOut = findViewById<TextView>(R.id.logoutbtn)

        logOut.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            intent.putExtra("password", password)
            startActivity(intent)
            finish()
        }

        editProf.setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            intent.putExtra("password", password)
            startActivity(intent)
            finish()
        }

        viewProf.setOnClickListener {
            val intent = Intent(this, ProfileView::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            intent.putExtra("password", password)
            startActivity(intent)
            finish()
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {}
        })
    }
}






