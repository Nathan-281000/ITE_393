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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginPage : AppCompatActivity() {
    private lateinit var idInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var returnToMain: TextView
    private lateinit var loginBtn: Button
    private var db = Firebase.firestore

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
        if (key) {
            imge1.setImageResource(R.drawable.araullo)
            campus = "PHINMA Araullo University"
        } else if (key1) {
            imge1.setImageResource(R.drawable.saint_jude)
            campus = "PHINMA Saint Jude collge"
        } else if (key2) {
            imge1.setImageResource(R.drawable.cagayan_de_oro)
            campus = "PHINMA Cagayan De Oro College"
        } else if (key3) {
            imge1.setImageResource(R.drawable.urdaneta)
            campus = "PHINMA University of Pangasinan"
        }

        loginBtn.setOnClickListener {
            if (idInput.text.isEmpty() && passwordInput.text.isEmpty()) {
                idInput.error = "Field not Filled.."
                passwordInput.error = "Field not Filled.."
            }
            else {
                signInStudent(campus)
            }
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(pass)
            }
        })
    }
    private fun signInStudent(path: String){
        val intent = Intent(this, HomePage::class.java)
        val studentId = idInput.text.toString()
        val studentPass = passwordInput.text.toString()
        val ref = db.collection(path).document(studentId)
        ref.get().addOnSuccessListener {
            if (it.exists()) {
                val pass = it.getString("password")
                if (pass == studentPass){
                    intent.putExtra("password", pass)
                    intent.putExtra("studentId", studentId)
                    intent.putExtra("campus", path)
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
