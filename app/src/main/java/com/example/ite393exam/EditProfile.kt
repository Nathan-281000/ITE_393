package com.example.ite393exam

//import com.google.firebase.auth.FirebaseAuth
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class EditProfile : AppCompatActivity() {
    private var db = Firebase.firestore
    private lateinit var stuLastName: EditText
    private lateinit var stuFirstName: EditText
    private lateinit var stuMiddleName: EditText
    private lateinit var stuBirthDate: EditText
    private lateinit var stuMale: RadioButton
    private lateinit var stuFemale: RadioButton
    private lateinit var stuMother: EditText
    private lateinit var stuFather: EditText
    private lateinit var stuNumber: EditText
    private lateinit var stuEmail: EditText
    private lateinit var stuFatherNumber: EditText
    private lateinit var stuMotherNumber: EditText
    private lateinit var stuRelFather: RadioButton
    private lateinit var stuRelMother: RadioButton
    private lateinit var stuRelGuardian: RadioButton
    private lateinit var stuGuardian: EditText
    private lateinit var stuGuardianAddress: EditText
    private lateinit var stuGuardianNumber: EditText
    private lateinit var stuCurrentAddress: EditText
    private lateinit var stuCurrentCity: EditText
    private lateinit var stuCurrentProvince: EditText
    private lateinit var stuCurrentCountry: EditText
    private lateinit var stuPermanentAddress: EditText
    private lateinit var stuPermanentCity: EditText
    private lateinit var stuPermanentProvince: EditText
    private lateinit var stuPermanentCountry: EditText
    private lateinit var userId : String
    private lateinit var university : String
    private lateinit var password : String
    private lateinit var gender : String
    private lateinit var guardianRelation : String

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile2)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {}
        })
        userId = intent.getStringExtra("studentId").toString()
        university = intent.getStringExtra("campus").toString()
        password = intent.getStringExtra("password").toString()

        stuLastName = findViewById(R.id.stuLastName)
        stuFirstName = findViewById(R.id.stuFirstName)
        stuMiddleName = findViewById(R.id.stuMiddleName)
        stuBirthDate = findViewById(R.id.stuBirthDate)
        stuMale = findViewById(R.id.stuMale)
        stuFemale = findViewById(R.id.stuFemale)
        stuMother = findViewById(R.id.stuMother)
        stuFather = findViewById(R.id.stuFather)
        stuNumber = findViewById(R.id.stuNumber)
        stuEmail = findViewById(R.id.stuEmail)
        stuFatherNumber = findViewById(R.id.stuFatherNumber)
        stuMotherNumber = findViewById(R.id.stuMotherNumber)
        stuRelFather = findViewById(R.id.stuRelFather)
        stuRelMother = findViewById(R.id.stuRelMother)
        stuRelGuardian = findViewById(R.id.stuRelGuardian)
        stuGuardian = findViewById(R.id.stuGuardian)
        stuGuardianAddress = findViewById(R.id.stuGuardianAddress)
        stuGuardianNumber = findViewById(R.id.stuGuardianNumber)
        stuCurrentAddress = findViewById(R.id.stuCurrentAddress)
        stuCurrentCity = findViewById(R.id.stuCurrentCity)
        stuCurrentProvince = findViewById(R.id.stuCurrentProvince)
        stuCurrentCountry = findViewById(R.id.stuCurrentCountry)
        stuPermanentAddress = findViewById(R.id.stuPermanentAddress)
        stuPermanentCity = findViewById(R.id.stuPermanentCity)
        stuPermanentProvince = findViewById(R.id.stuPermanentProvince)
        stuPermanentCountry = findViewById(R.id.stuPermanentCountry)

        // Display Contents
        val ref = db.collection(university).document(userId)
        ref.get().addOnSuccessListener {
            if (it != null) {
                stuLastName.setText(it.getString("lastName"))
                stuFirstName.setText(it.getString("firstName"))
                stuMiddleName.setText(it.getString("middleName"))
                stuBirthDate.setText(it.getString("birthdate"))
                if (it.getString("gender") == "Male") {
                    stuMale.isChecked = true
                    gender = "Male"
                } else {
                    gender = "Female"
                    stuFemale.isChecked = true
                }
                stuMother.setText(it.getString("motherName"))
                stuFather.setText(it.getString("fatherName"))
                stuNumber.setText(it.getString("number"))
                stuEmail.setText(it.getString("email"))
                stuFatherNumber.setText(it.getString("fatherNumber"))
                stuMotherNumber.setText(it.getString("motherNumber"))
                stuGuardian.setText(it.getString("guardianName"))
                if (it.getString("guardianRelation") == "Father") {
                    guardianRelation = "Father"
                    stuRelFather.isChecked = true
                } else if (it.getString("guardianRelation") == "Mother") {
                    guardianRelation = "Mother"
                    stuRelMother.isChecked = true
                } else {
                    guardianRelation = "Guardian"
                    stuRelGuardian.isChecked = true
                }
                stuGuardianAddress.setText(it.getString("guardianAddress"))
                stuGuardianNumber.setText(it.getString("guardianNumber"))
                stuCurrentAddress.setText(it.getString("currentAddress"))
                stuCurrentCity.setText(it.getString("currentCity"))
                stuCurrentProvince.setText(it.getString("currentProvince"))
                stuCurrentCountry.setText(it.getString("currentCountry"))
                stuPermanentAddress.setText(it.getString("permanentAddress"))
                stuPermanentCity.setText(it.getString("permanentCity"))
                stuPermanentProvince.setText(it.getString("permanentProvince"))
                stuPermanentCountry.setText(it.getString("permanentCountry"))

            }
        }

        val saveBtn = findViewById<Button>(R.id.saveBtn)
        val backBtn = findViewById<Button>(R.id.backBtn)

        saveBtn.setOnClickListener {
            updateProfile()
            val intent = Intent(this, Profile::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }

        backBtn.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }

    }
    private fun updateProfile() {
        val gender = if (stuMale.isChecked) {
            "Male"
        } else {
            "Female"
        }
        val relation = if (stuRelFather.isChecked) {
            "Father"
        } else if (stuRelMother.isChecked) {
            "Mother"
        } else {
            "Guardian"
        }
        db.collection(university).document(userId).update(
            "lastName", stuLastName.text.toString(),
            "firstName", stuFirstName.text.toString(),
            "middleName", stuMiddleName.text.toString(),
            "birthdate", stuBirthDate.text.toString(),
            "gender", gender,
            "motherName", stuMother.text.toString(),
            "fatherName", stuFather.text.toString(),
            "number", stuNumber.text.toString(),
            "email", stuEmail.text.toString(),
            "fatherNumber", stuFatherNumber.text.toString(),
            "motherNumber", stuMotherNumber.text.toString(),
            "guardianName", stuGuardian.text.toString(),
            "guardianRelation", relation,
            "guardianAddress", stuGuardianAddress.text.toString(),
            "guardianNumber", stuGuardianNumber.text.toString(),
            "currentAddress", stuCurrentAddress.text.toString(),
            "currentCity", stuCurrentCity.text.toString(),
            "currentProvince", stuCurrentProvince.text.toString(),
            "currentCountry", stuCurrentCountry.text.toString(),
            "permanentAddress", stuPermanentAddress.text.toString(),
            "permanentCity", stuPermanentCity.text.toString(),
            "permanentProvince", stuPermanentProvince.text.toString(),
            "permanentCountry", stuPermanentCountry.text.toString()
        )
    }
}


