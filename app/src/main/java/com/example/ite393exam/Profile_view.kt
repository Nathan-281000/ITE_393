package com.example.ite393exam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
//import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Profile_view : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    //private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_view)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {}
        })

        //auth = FirebaseAuth.getInstance()
       /*val user = auth.currentUser
        if (user == null) {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginPage::class.java))
            finish()
            return
        }

        */

        val stuName = findViewById<TextView>(R.id.stuName)
        val stuGender = findViewById<TextView>(R.id.stuGender)
        val stuEmail = findViewById<TextView>(R.id.stuEmail)  // Add other fields here
        val stuNumber = findViewById<TextView>(R.id.stuNumber)
        val stuBirthDate = findViewById<TextView>(R.id.stuBirthDate)
        val stuGuardian = findViewById<TextView>(R.id.stuGuardian)
        val stuMother = findViewById<TextView>(R.id.stuMother)
        val stuFather = findViewById<TextView>(R.id.stuFather)
        val stuGuardianAddress = findViewById<TextView>(R.id.stuGuardianAddress)
        val stuGuardianNumber = findViewById<TextView>(R.id.stuGuardianNumber)
        val stuCurrentAddress = findViewById<TextView>(R.id.stuCurrentAddress)
        val stuCurrentCity = findViewById<TextView>(R.id.stuCurrentCity)
        val stuCurrentProvince = findViewById<TextView>(R.id.stuCurrentProvince)
        val stuCurrentCountry = findViewById<TextView>(R.id.stuCurrentCountry)
        val stuPermanentAddress = findViewById<TextView>(R.id.stuPermanentAddress)
        val stuPermanentCity = findViewById<TextView>(R.id.stuPermanentCity)
        val stuPermanentProvince = findViewById<TextView>(R.id.stuPermanentProvince)
        val stuPermanentCountry = findViewById<TextView>(R.id.stuPermanentCountry)
        val backBtn = findViewById<Button>(R.id.backBtn)

        database = FirebaseDatabase.getInstance().getReference("PhinmaLearningApp")
            .child("Users")
            //.child(user.uid)


        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    stuName.text = snapshot.child("stuName").getValue(String::class.java) ?: "N/A"
                    stuEmail.text = snapshot.child("stuEmail").getValue(String::class.java) ?: "N/A"
                    stuNumber.text = snapshot.child("stuNumber").getValue(String::class.java) ?: "N/A"
                    stuBirthDate.text = snapshot.child("stuBirthDate").getValue(String::class.java) ?: "N/A"
                    stuGender.text = snapshot.child("stuGender").getValue(String::class.java) ?: "N/A"
                    stuGuardian.text = snapshot.child("stuGuardian").getValue(String::class.java) ?: "N/A"
                    stuMother.text = snapshot.child("stuMother").getValue(String::class.java) ?: "N/A"
                    stuFather.text = snapshot.child("stuFather").getValue(String::class.java) ?: "N/A"
                    stuGuardianAddress.text = snapshot.child("stuGuardianAddress").getValue(String::class.java) ?: "N/A"
                    stuGuardianNumber.text = snapshot.child("stuGuardianNumber").getValue(String::class.java) ?: "N/A"
                    stuCurrentAddress.text = snapshot.child("stuCurrentAddress").getValue(String::class.java) ?: "N/A"
                    stuCurrentCity.text = snapshot.child("stuCurrentCity").getValue(String::class.java) ?: "N/A"
                    stuCurrentProvince.text = snapshot.child("stuCurrentProvince").getValue(String::class.java) ?: "N/A"
                    stuCurrentCountry.text = snapshot.child("stuCurrentCountry").getValue(String::class.java) ?: "N/A"
                    stuPermanentAddress.text = snapshot.child("stuPermanentAddress").getValue(String::class.java) ?: "N/A"
                    stuPermanentCity.text = snapshot.child("stuPermanentCity").getValue(String::class.java) ?: "N/A"
                    stuPermanentProvince.text = snapshot.child("stuPermanentProvince").getValue(String::class.java) ?: "N/A"
                    stuPermanentCountry.text = snapshot.child("stuPermanentCountry").getValue(String::class.java) ?: "N/A"

                } else {
                    Toast.makeText(applicationContext, "No Profile Data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "Database Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })

        backBtn.setOnClickListener {
            finish()
        }
    }
}

