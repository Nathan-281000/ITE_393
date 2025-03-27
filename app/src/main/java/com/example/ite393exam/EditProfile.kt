package com.example.ite393exam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
//import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class EditProfile : AppCompatActivity() {
   // private lateinit var database: DatabaseReference
    //private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile2)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {}
        })

        //auth = FirebaseAuth.getInstance()
        //val user = auth.currentUser

        /*if (user == null) {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginPage::class.java))
            finish()
            return
        }

        database = FirebaseDatabase.getInstance().getReference("PhinmaLearningApp")
            .child("Users")
            .child(user.uid)
         */

        val stuName = findViewById<EditText>(R.id.stuName)
        val stuBirthDate = findViewById<EditText>(R.id.stuBirthDate)
        val stuMale = findViewById<RadioButton>(R.id.stuMale)
        val stuMother = findViewById<EditText>(R.id.stuMother)
        val stuFather = findViewById<EditText>(R.id.stuFather)
        val stuNumber = findViewById<EditText>(R.id.stuNumber)
        val stuEmail = findViewById<EditText>(R.id.stuEmail)
        val stuFatherNumber = findViewById<EditText>(R.id.stuFatherNumber)
        val stuMotherNumber = findViewById<EditText>(R.id.stuMotherNumber)
        val stuRelFather = findViewById<RadioButton>(R.id.stuRelFather)
        val stuRelMother = findViewById<RadioButton>(R.id.stuRelMother)
        val stuGuardianAddress = findViewById<EditText>(R.id.stuGuardianAddress)
        val stuGuardianNumber = findViewById<EditText>(R.id.stuGuardianNumber)
        val stuCurrentAddress = findViewById<EditText>(R.id.stuCurrentAddress)
        val stuCurrentCity = findViewById<EditText>(R.id.stuCurrentCity)
        val stuCurrentProvince = findViewById<EditText>(R.id.stuCurrentProvince)
        val stuCurrentCountry = findViewById<EditText>(R.id.stuCurrentCountry)
        val stuPermanentAddress = findViewById<EditText>(R.id.stuPermanentAddress)
        val stuPermanentCity = findViewById<EditText>(R.id.stuPermanentCity)
        val stuPermanentProvince = findViewById<EditText>(R.id.stuPermanentProvince)
        val stuPermanentCountry = findViewById<EditText>(R.id.stuPermanentCountry)

        val saveBtn = findViewById<Button>(R.id.saveBtn)
        val backBtn = findViewById<Button>(R.id.backBtn)
/*
        database.child("stuName").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    stuName.setText(snapshot.getValue(String::class.java))
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "Failed to load profile", Toast.LENGTH_SHORT).show()
            }
        })
        database.child("stuBirthDate").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    stuBirthDate.setText(snapshot.getValue(String::class.java))
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "Failed to load profile", Toast.LENGTH_SHORT).show()
            }
        })


        saveBtn.setOnClickListener {
            val name = stuName.text.toString().trim()
            val birthDate = stuBirthDate.text.toString().trim()
            val gender = if (stuMale.isActivated){
                "Male"
            }else {
                "Female"
            }
            val mother = stuMother.text.toString().trim()
            val father = stuFather.text.toString().trim()
            val number = stuNumber.text.toString().trim()
            val email = stuEmail.text.toString().trim()
            val fatherNumber = stuFatherNumber.text.toString().trim()
            val motherNumber = stuMotherNumber.text.toString().trim()
            val relationship = if (stuRelFather.isActivated){
                "Father"
            }else if (stuRelMother.isActivated){
                "Mother"
            }else {
                "Guardian"
            }
            val guardianAddress = stuGuardianAddress.text.toString().trim()
            val guardianNumber = stuGuardianNumber.text.toString().trim()
            val currentAddress = stuCurrentAddress.text.toString().trim()
            val currentCity = stuCurrentCity.text.toString().trim()
            val currentProvince = stuCurrentProvince.text.toString().trim()
            val currentCountry = stuCurrentCountry.text.toString().trim()
            val permanentAddress = stuPermanentAddress.text.toString().trim()
            val permanentCity = stuPermanentCity.text.toString().trim()
            val permanentProvince = stuPermanentProvince.text.toString().trim()
            val permanentCountry = stuPermanentCountry.text.toString().trim()

            if (name.isNotEmpty()) {
                database.child("stuName").setValue(name)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show()

                        database.child("stuName").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }

                        val intent = Intent(this, Profile::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                        startActivity(intent)

                        finish()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failed to Update", Toast.LENGTH_SHORT).show()
                    }
                database.child("stuBirthDate").setValue(birthDate)
                    .addOnSuccessListener {
                        database.child("stuName").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }

                        val intent = Intent(this, Profile::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                        startActivity(intent)

                        finish()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failed to Update", Toast.LENGTH_SHORT).show()
                    }
                database.child("stuGender").setValue(gender)
                    .addOnSuccessListener {
                        database.child("stuGender").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }

                        val intent = Intent(this, Profile::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                        startActivity(intent)

                        finish()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failed to Update", Toast.LENGTH_SHORT).show()
                    }
                database.child("stuEmail").setValue(email)
                    .addOnSuccessListener {
                        database.child("stuEmail").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuNumber").setValue(number)
                    .addOnSuccessListener {
                        database.child("stuNumber").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuMother").setValue(mother)
                    .addOnSuccessListener {
                        database.child("stuMother").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuFather").setValue(father)
                    .addOnSuccessListener {
                        database.child("stuFather").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuFatherNumber").setValue(fatherNumber)
                    .addOnSuccessListener {
                        database.child("stuFatherNumber").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuMotherNumber").setValue(motherNumber)
                    .addOnSuccessListener {
                        database.child("stuMotherNumber").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuGuardian").setValue(relationship)
                    .addOnSuccessListener {
                        database.child("stuGuardian").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuGuardianAddress").setValue(guardianAddress)
                    .addOnSuccessListener {
                        database.child("stuGuardianAddress").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuGuardianNumber").setValue(guardianNumber)
                    .addOnSuccessListener {
                        database.child("stuGuardianNumber").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuCurrentAddress").setValue(currentAddress)
                    .addOnSuccessListener {
                        database.child("stuCurrentAddress").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuCurrentCity").setValue(currentCity)
                    .addOnSuccessListener {
                        database.child("stuCurrentCity").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuCurrentProvince").setValue(currentProvince)
                    .addOnSuccessListener {
                        database.child("stuCurrentProvince").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuCurrentCountry").setValue(currentCountry)
                    .addOnSuccessListener {
                        database.child("stuCurrentCountry").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuPermanentAddress").setValue(permanentAddress)
                    .addOnSuccessListener {
                        database.child("stuPermanentAddress").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuPermanentCity").setValue(permanentCity)
                    .addOnSuccessListener {
                        database.child("stuPermanentCity").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuPermanentProvince").setValue(permanentProvince)
                    .addOnSuccessListener {
                        database.child("stuPermanentProvince").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }
                database.child("stuPermanentCountry").setValue(permanentCountry)
                    .addOnSuccessListener {
                        database.child("stuPermanentCountry").get().addOnSuccessListener { snapshot ->
                            val savedValue = snapshot.getValue(String::class.java)
                            println("🔥 DEBUG: Firebase Saved Name → $savedValue")
                        }
                    }

            } else {
                Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        backBtn.setOnClickListener {
            finish()
        }

 */
    }
}


