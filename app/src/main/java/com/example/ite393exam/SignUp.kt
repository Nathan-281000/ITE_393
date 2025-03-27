package com.example.ite393exam


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.firestore

class SignUp : AppCompatActivity() {
    private var db = Firebase.firestore
    private lateinit var dbRef : DatabaseReference
    private lateinit var campus : Spinner
    private lateinit var studentId: EditText
    private lateinit var studentName: EditText
    private lateinit var studentPassword: EditText
    private lateinit var studentRePassword: EditText
    private lateinit var signUp: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        campus = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.campus,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            campus.adapter = adapter
        }
        studentId = findViewById(R.id.studentId)
        studentName = findViewById(R.id.studentName)
        studentPassword = findViewById(R.id.password)
        studentRePassword = findViewById(R.id.rePassword)
        signUp = findViewById(R.id.signUpBtn)

        val selectedCampus = campus.selectedItem.toString()
        dbRef = FirebaseDatabase.getInstance().getReference(selectedCampus)
        signUp.setOnClickListener {
            if (studentPassword.text.toString() != studentRePassword.text.toString()){
                studentPassword.error = "Passwords do not match"
                studentRePassword.error = "Passwords do not match"
            }else signUpStudent(selectedCampus)
        }
    }

    private fun signUpStudent(campus: String){
        val fullName = studentName.text.toString()
        val studentId = studentId.text.toString()
        val password = studentPassword.text.toString()
        db.collection(campus).document(studentId).set(StudentData(fullName, studentId, password))
            .addOnSuccessListener {
                Toast.makeText(this, "Student Account Created Successfully", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, LoginPage::class.java))
            }
            .addOnFailureListener {
                Toast.makeText(this, "Student Account Creation Failed", Toast.LENGTH_LONG).show()
            }
    }
}
