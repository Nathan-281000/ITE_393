package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginPage : AppCompatActivity() {
    private lateinit var idInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var returnToMain: TextView
    private lateinit var loginBtn: Button
    private var db = Firebase.firestore
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)
        val imge1 = findViewById<ImageView>(R.id.imageView4)
        imge1.setImageResource(R.drawable.upang_dagupan)

        val key = intent.getBooleanExtra("keyArraullo", false)
        val key1 = intent.getBooleanExtra("keySaintjude", false)
        val key2 = intent.getBooleanExtra("keyCagayan", false)
        val key3 = intent.getBooleanExtra("keyUpang", false)
        val pass = Intent(this, MainActivity::class.java)

        idInput= findViewById(R.id.studentId)
        passwordInput = findViewById(R.id.password)
        returnToMain= findViewById(R.id.returnToMain)
        loginBtn = findViewById(R.id.loginBtn)

        returnToMain.setOnClickListener {
            startActivity(pass)
        }


        var campus = "None"
        firebaseDatabase = FirebaseDatabase.getInstance()
        if (key) {
            imge1.setImageResource(R.drawable.araullo)
            databaseReference = firebaseDatabase.getReference("PHINMA Araullo University")
            campus = "PHINMA Araullo University"
        } else if (key1) {
            imge1.setImageResource(R.drawable.saint_jude)
            databaseReference = firebaseDatabase.getReference("PHINMA Saint Jude collge")
            campus = "PHINMA Saint Jude collge"
        } else if (key2) {
            imge1.setImageResource(R.drawable.cagayan_de_oro)
            databaseReference = firebaseDatabase.getReference("PHINMA Cagayan De Oro College")
            campus = "PHINMA Cagayan De Oro College"
        } else if (key3) {
            imge1.setImageResource(R.drawable.upang_dagupan)
            databaseReference = firebaseDatabase.getReference("PHINMA University of Pangasinan")
            campus = "PHINMA University of Pangasinan"
        }

        loginBtn.setOnClickListener {
            signInStudent(campus)
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(pass)
            }
        })
    }
    private fun signInStudent(path: String){
        val intent = Intent(this, Home_Page::class.java)
        val studentId = idInput.text.toString()
        val studentPass = passwordInput.text.toString()
        val ref = db.collection(path).document(studentId)
        ref.get().addOnSuccessListener {
            if (it.exists()) {
                val pass = it.getString("password")
                if (pass == studentPass){
                    startActivity(intent)
                } else {
                    passwordInput.error = "Wrong Password"
                }
            }else {
                idInput.error = "Student ID does not exist"
            }
        }
    }
}
