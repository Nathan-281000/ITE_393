package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class ProfileView : AppCompatActivity() {
    private var db = Firebase.firestore
    private var userId : String? = null
    private var university : String? = null
    private lateinit var stuId : TextView
    private lateinit var college : TextView
    private lateinit var stuBirthDate : TextView
    private lateinit var stuGender : TextView
    private lateinit var stuName : TextView
    private lateinit var stuCourse : TextView
    private lateinit var stuFather : TextView
    private lateinit var stuMother : TextView
    private lateinit var stuNumber : TextView
    private lateinit var stuFatherNumber : TextView
    private lateinit var stuMotherNumber : TextView
    private lateinit var stuEmail : TextView
    private lateinit var stuGuardian : TextView
    private lateinit var stuGuardianNumber : TextView
    private lateinit var stuGuardianRelation : TextView
    private lateinit var stuGuardianAddress : TextView
    private lateinit var stuCurrentAddress : TextView
    private lateinit var stuCurrentCountry : TextView
    private lateinit var stuCurrentProvince : TextView
    private lateinit var stuCurrentCity : TextView
    private lateinit var stuPermanentAddress : TextView
    private lateinit var stuPermanentCountry : TextView
    private lateinit var stuPermanentProvince : TextView
    private lateinit var stuPermanentCity : TextView
    private lateinit var backBtn : Button


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_view)

        userId = intent.getStringExtra("studentId")
        university = intent.getStringExtra("campus")

        // Initialize TextViews
        stuId = findViewById(R.id.stuID)
        college = findViewById(R.id.college)
        stuBirthDate = findViewById(R.id.stuBirthDate)
        stuGender = findViewById(R.id.stuGender)
        stuName = findViewById(R.id.stuName)
        stuCourse = findViewById(R.id.course)
        stuFather = findViewById(R.id.stuFather)
        stuMother = findViewById(R.id.stuMother)
        stuNumber = findViewById(R.id.stuNumber)
        stuFatherNumber = findViewById(R.id.stuFatherNumber)
        stuMotherNumber = findViewById(R.id.stuMotherNumber)
        stuEmail = findViewById(R.id.stuEmail)
        stuGuardian = findViewById(R.id.stuGuardian)
        stuGuardianNumber = findViewById(R.id.stuGuardianNumber)
        stuGuardianRelation = findViewById(R.id.stuRelation)
        stuGuardianAddress = findViewById(R.id.stuGuardianAddress)
        stuCurrentAddress = findViewById(R.id.stuCurrentAddress)
        stuCurrentCountry = findViewById(R.id.stuCurrentCountry)
        stuCurrentProvince = findViewById(R.id.stuCurrentProvince)
        stuCurrentCity = findViewById(R.id.stuCurrentCity)
        stuPermanentAddress = findViewById(R.id.stuPermanentAddress)
        stuPermanentCountry = findViewById(R.id.stuPermanentCountry)
        stuPermanentProvince = findViewById(R.id.stuPermanentProvince)
        stuPermanentCity = findViewById(R.id.stuPermanentCity)
        backBtn = findViewById(R.id.backBtn)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {}
        })
        val ref = db.collection(university!!).document(userId!!)
        ref.get().addOnSuccessListener {
            if (it != null) {
                val lastName = it.getString("lastName")
                val firstName = it.getString("firstName")
                val middleName = it.getString("middleName")
                stuId.text = it.getString("studentId")
                college.text = it.getString("college")
                stuBirthDate.text = it.getString("birthdate")
                stuGender.text = it.getString("gender")
                stuName.text = "$lastName, $firstName $middleName"
                stuCourse.text = it.getString("course")
                stuFather.text = it.getString("fatherName")
                stuMother.text = it.getString("motherName")
                stuNumber.text = it.getString("number")
                stuFatherNumber.text = it.getString("fatherNumber")
                stuMotherNumber.text = it.getString("motherNumber")
                stuEmail.text = it.getString("email")
                stuGuardian.text = it.getString("guardianName")
                stuGuardianNumber.text = it.getString("guardianNumber")
                stuGuardianRelation.text = it.getString("guardianRelation")
                stuGuardianAddress.text = it.getString("guardianAddress")
                stuCurrentAddress.text = it.getString("currentAddress")
                stuCurrentCountry.text = it.getString("currentCountry")
                stuCurrentProvince.text = it.getString("currentProvince")
                stuCurrentCity.text = it.getString("currentCity")
                stuPermanentAddress.text = it.getString("permanentAddress")
                stuPermanentCountry.text = it.getString("permanentCountry")
                stuPermanentProvince.text = it.getString("permanentProvince")
                stuPermanentCity.text = it.getString("permanentCity")
            }
            else{
                Toast.makeText(this, "No such document", Toast.LENGTH_SHORT).show()
            }
        }
        backBtn.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
        }
    }
}

