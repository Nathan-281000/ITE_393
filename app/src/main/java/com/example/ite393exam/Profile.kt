package com.example.ite393exam

//import com.google.firebase.auth.FirebaseAuth
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Profile : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var studentName: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {}
        })

        database = FirebaseDatabase.getInstance().getReference("PhinmaLearningApp")
            .child("Users")
            //.child(user.uid)

        val course = findViewById<ImageButton>(R.id.course)
        val modality = findViewById<ImageButton>(R.id.modules)
        val maps = findViewById<ImageButton>(R.id.maps)
        val profile = findViewById<ImageButton>(R.id.profile)
        course.setOnClickListener {
            val intent = Intent(this, Course::class.java)
            startActivity(intent)
            finish()
        }
        modality.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()
        }
        maps.setOnClickListener {
            val intent = Intent(this, Maps::class.java)
            startActivity(intent)
            finish()
        }
        profile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
            finish()
        }

        studentName = findViewById(R.id.stuName)
        val editProf = findViewById<Button>(R.id.editProf)
        val viewProf = findViewById<Button>(R.id.viewProf)
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
    }



    override fun onResume() {
        super.onResume()
        loadProfileData()
    }




    @SuppressLint("SetTextI18n")
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


