package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
//import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Profile : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    //private lateinit var auth: FirebaseAuth
    private lateinit var studentName: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

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

        database = FirebaseDatabase.getInstance().getReference("PhinmaLearningApp")
            .child("Users")
            //.child(user.uid)



        studentName = findViewById(R.id.stuName)
        val editProf = findViewById<Button>(R.id.editProf)
        val viewProf = findViewById<Button>(R.id.viewProf)
        val btnHP = findViewById<Button>(R.id.btnHP)
        val logOut = findViewById<TextView>(R.id.logoutbtn)

        studentName.text = "Loading..."

        loadProfileData()

        logOut.setOnClickListener {
            //auth.signOut()
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }

        editProf.setOnClickListener {
            startActivity(Intent(this, EditProfile::class.java))
        }

        viewProf.setOnClickListener {
            startActivity(Intent(this, Profile_view::class.java))
        }

        btnHP.setOnClickListener {
            startActivity(Intent(this, Home_Page::class.java))
        }
    }



    override fun onResume() {
        super.onResume()
        loadProfileData()
    }




    private fun loadProfileData() {
        database.child("stuName").get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val updatedName = snapshot.getValue(String::class.java) ?: "No Name Found"
                println("🔥 DEBUG: Profile Loaded Name → $updatedName")
                studentName.text = updatedName
            } else {
                println("❌ DEBUG: No Profile Found in Firebase")
                studentName.text = "No Profile Found"
                Toast.makeText(this@Profile, "No Profile Found", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            println("🚨 DEBUG: Failed to load profile data")
            Toast.makeText(this@Profile, "Failed to Load Profile", Toast.LENGTH_SHORT).show()
        }
    }
}


