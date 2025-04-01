package com.example.ite393exam


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
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
    private lateinit var studentLastName: EditText
    private lateinit var studentFirstName: EditText
    private lateinit var studentMiddleName: EditText
    private lateinit var studentPassword: EditText
    private lateinit var studentRePassword: EditText
    private lateinit var studentGender: Spinner
    private lateinit var studentCollege: Spinner
    private lateinit var studentCourse: Spinner
    private lateinit var studentDay: Spinner
    private lateinit var studentMonth: Spinner
    private lateinit var studentYear: Spinner
    private lateinit var signUp: Button
    private lateinit var scrollView: ScrollView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        campus = findViewById(R.id.spinner)
        studentGender = findViewById(R.id.spinnerGender)
        studentCollege = findViewById(R.id.spinnerCollege)
        studentCourse = findViewById(R.id.spinnerCourse)
        studentId = findViewById(R.id.studentId)
        studentDay = findViewById(R.id.days)
        studentMonth = findViewById(R.id.months)
        studentYear = findViewById(R.id.years)
        studentLastName = findViewById(R.id.studentLastName)
        studentFirstName = findViewById(R.id.studentFirstName)
        studentMiddleName = findViewById(R.id.studentMiddleName)
        studentPassword = findViewById(R.id.password)
        studentRePassword = findViewById(R.id.rePassword)
        signUp = findViewById(R.id.signUpBtn)
        scrollView = findViewById(R.id.scrollView3)

        // Visibility


        // Getting Intents

        // Putting Intents at their Designated Field

        ArrayAdapter.createFromResource(
            this,
            R.array.campus,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            campus.adapter = adapter
        }
        campus.setSelection(campus.selectedItemPosition).toString()
        ArrayAdapter.createFromResource(
            this,
            R.array.days,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            studentDay.adapter = adapter
        }
        studentDay.setSelection(studentDay.selectedItemPosition).toString()
        ArrayAdapter.createFromResource(
            this,
            R.array.month,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            studentMonth.adapter = adapter
        }
        studentMonth.setSelection(studentMonth.selectedItemPosition).toString()
        ArrayAdapter.createFromResource(
            this,
            R.array.years,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            studentYear.adapter = adapter
        }
        studentYear.setSelection(studentYear.selectedItemPosition).toString()
        ArrayAdapter.createFromResource(
            this,
            R.array.campus,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            campus.adapter = adapter
        }
        campus.setSelection(campus.selectedItemPosition).toString()
        ArrayAdapter.createFromResource(
            this,
            R.array.gender,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            studentGender.adapter = adapter
        }
        studentGender.setSelection(studentGender.selectedItemPosition).toString()
        ArrayAdapter.createFromResource(
            this,
            R.array.college,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            studentCollege.adapter = adapter
        }
        studentCollege.setSelection(studentCollege.selectedItemPosition).toString()
        ArrayAdapter.createFromResource(
            this,
            R.array.course,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            studentCourse.adapter = adapter
        }
        studentCourse.setSelection(studentCourse.selectedItemPosition).toString()


        dbRef = FirebaseDatabase.getInstance().getReference(campus.selectedItem.toString())
        signUp.setOnClickListener {
            if ((studentPassword.text.toString() != studentRePassword.text.toString()) || (studentPassword.text.isEmpty() && studentRePassword.text.isEmpty())){
                studentPassword.error = "Passwords do not match or not filled"
                studentRePassword.error = "Passwords do not match or not filled"
            }else {
                if (studentId.text.isEmpty() && studentLastName.text.isEmpty()){
                    studentId.error = "Field not filled..."
                    studentLastName.error = "Field not filled..."
                }else {
                    signUpStudent(campus.selectedItem.toString())
                }
            }
        }
    }
    private fun signUpStudent(chosenCampus: String){
        val lastName = studentLastName.text.toString()
        val firstName = studentFirstName.text.toString()
        val middleName = studentMiddleName.text.toString()
        val studentId = studentId.text.toString()
        val gender = studentGender.selectedItem.toString()
        val birthdate = "${studentMonth.selectedItem} ${studentDay.selectedItem}, ${studentYear.selectedItem}"
        val university = campus.selectedItem.toString()
        val college = studentCollege.selectedItem.toString()
        val course = studentCourse.selectedItem.toString()
        val password = studentPassword.text.toString()
        db.collection(chosenCampus).document(studentId).set(StudentData(
            lastName,
            firstName,
            middleName,
            studentId,
            password,
            gender,
            birthdate,
            university,
            college,
            course))
            .addOnSuccessListener {
                Toast.makeText(this, "Student Account Created Successfully", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Student Account Creation Failed", Toast.LENGTH_LONG).show()
            }
    }
}
