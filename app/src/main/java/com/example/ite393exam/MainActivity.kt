@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection"
)

package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

@Suppress("SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection"
)
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val signUpLink = findViewById<TextView>(R.id.signUpLink)
        val btnUpang = findViewById<ImageView>(R.id.upangDagups)
        val btnArraullo = findViewById<ImageView>(R.id.araullo)
        val btnSt = findViewById<ImageView>(R.id.saintjude)
        val btnCagayan = findViewById<ImageView>(R.id.cagayan_de_oro)

        val pass = Intent(this, LoginPage::class.java)

        btnUpang.setOnClickListener{
            pass.putExtra("keyUpang",true)
            pass.putExtra("keyArraullo",false)
            pass.putExtra("keySaintjude",false)
            pass.putExtra("keyCagayan",false)
            startActivity(pass)
        }
        btnArraullo.setOnClickListener{
           pass.putExtra("keyUpang",false)
           pass.putExtra("keyArraullo",true)
           pass.putExtra("keySaintjude",false)
           pass.putExtra("keyCagayan",false)
           startActivity(pass)
        }
        btnSt.setOnClickListener{
           pass.putExtra("keyUpang",false)
           pass.putExtra("keyArraullo",false)
           pass.putExtra("keySaintjude",true)
           pass.putExtra("keyCagayan",false)
           startActivity(pass)
        }
        btnCagayan.setOnClickListener{
           pass.putExtra("keyUpang",false)
           pass.putExtra("keyArraullo",false)
           pass.putExtra("keySaintjude",false)
           pass.putExtra("keyCagayan",true)
           startActivity(pass)
        }
        signUpLink.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val builder = AlertDialog.Builder(this@MainActivity).setTitle("Exit  App?").setMessage("Are you sure you want exit this app?")
                    .setPositiveButton("Yes") { _, _ ->
                        finishAffinity()
                        finishAndRemoveTask()
                    }
                    .setNegativeButton("No") { dialog, _ ->
                        dialog.dismiss()
                    }
                builder.create().show()
            }
        })

    }

}