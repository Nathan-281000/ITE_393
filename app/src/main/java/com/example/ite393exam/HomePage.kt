package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ite393exam.databinding.ActivityHomePageBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class HomePage : AppCompatActivity() {
    private var userId : String? = null
    private var university : String? = null
    private var password : String? = null
    private val eventsMap = mapOf(
        // ✅ Ensuring correct year (2025) for February 14
        "2025-02-14" to "10TH FDC, Valentine's Day",

        // June
        "2025-06-01" to "First Week Hi and KUDOS",

        // July
        "2025-07-17" to "Welcome Assembly",
        "2025-07-18" to "General Assembly",
        "2025-07-19" to "Bridging The Gaps",

        "2025-07-15" to "First Week Hi v.2",
        "2025-07-25" to "Bridging The Gap 2.0",
        "2025-07-26" to "General Assembly GPA and Tactical",
        "2025-07-31" to "Nutrition Month Celebration (TVL)",

        // August
        "2025-08-01" to "Convention PICE",
        "2025-08-02" to "Youth Search 2024 (UYFCYM)",
        "2025-08-05" to "P1 Examinations (Upper Years)",
        "2025-08-15" to "Buwan ng Wika",
        "2025-08-23" to "Abel Kamustahan",
        "2025-08-27" to "P1 Examination (Freshmen and SHS gr 11)",

        // September
        "2025-09-06" to "Eucharistic Celebration",
        "2025-09-12" to "Mathematics and Science Fest",
        "2025-09-13" to "Social Entrepreneurship",
        "2025-09-19" to "Business Expo, Abel Kamustahan",
        "2025-09-20" to "PUCU Fest, CITE Fest",
        "2025-09-21" to "CITE Fest",

        // October
        "2025-10-03" to "Teachers and Staff Appreciation Day",
        "2025-10-04" to "Rosary Devotion",
        "2025-10-09" to "League of Leaders",
        "2025-10-10" to "Criminology Day",
        "2025-10-12" to "Clean Up Drive",

        // November
        "2025-11-06" to "English Fest",
        "2025-11-08" to "Testimonial CEA",
        "2025-11-21" to "P3 Examination (Freshmen)",
        "2025-11-31" to "SHS Sports Fest",

        // December
        "2025-12-03" to "Lamaparaan",
        "2025-12-09" to "Ningning Project",
        "2025-12-16" to "2nd Quarterly Exam (gr 11)",

        // February
        "2026-02-03" to "Eucharistic Celebration",
        "2026-02-05" to "Outreach Program",
        "2026-02-07" to "Mass Blood Donation",
        "2026-02-11" to "Thanks Giving Mass",
        "2026-02-13" to "Valentine's Day",
        "2026-02-14" to "10TH FDC"
    )

    private var selectedDate: String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(
        Calendar.getInstance().time
    )



    @SuppressLint("MissingInflatedId")
    private lateinit var binding: ActivityHomePageBinding

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userId = intent.getStringExtra("studentId").toString()
        university = intent.getStringExtra("campus").toString()

        Toast.makeText(this, "Welcome $userId", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Welcome to $university", Toast.LENGTH_SHORT).show()

        val calendarView = findViewById<CalendarView>(R.id.calendarView)

        fun updateUIWithDate(date: String) {
            val eventDetails = eventsMap[date] ?: "No events on this day"
            Toast.makeText(this, "Date: $date", Toast.LENGTH_LONG).show()
            if (!eventDetails.contains("No events on this day")) {
                val intent = Intent(this, EventActivity::class.java)
                intent.putExtra("studentId", userId)
                intent.putExtra("campus", university)
                intent.putExtra("SELECTED_DATE", date)
                intent.putExtra("EVENT_DETAILS", eventDetails)
                startActivity(intent)
            }
        }
        val ask = findViewById<ImageButton>(R.id.message)
        ask.setOnClickListener {
            val intent = Intent(this, AskMe::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
        }
        val market = findViewById<ImageView>(R.id.market)
        market.setOnClickListener {
            val intent = Intent(this, Market::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
        }

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth)
            updateUIWithDate(selectedDate)
        }



        binding.coursebtn.setOnClickListener {
            val intent = Intent(this, Course::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        binding.modules.setOnClickListener {
            val intent = Intent(this, Modules::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        binding.maps.setOnClickListener {
            val intent = Intent(this, Maps::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        binding.profile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            startActivity(intent)
            finish()
        }
        binding.about.setOnClickListener {
            val intent = Intent(this, about::class.java)
            intent.putExtra("studentId", userId)
            intent.putExtra("campus", university)
            intent.putExtra("password", password)
            startActivity(intent)
            finish()
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val builder = AlertDialog.Builder(this@HomePage).setTitle("Logging Out?").setMessage("Are you sure you want to log out?")
                    .setPositiveButton("Yes") { _, _ ->
                        startActivity(Intent(this@HomePage, MainActivity::class.java))
                    }
                    .setNegativeButton("No") { dialog, _ ->
                        dialog.dismiss()
                    }
                builder.create().show()
            }
        })
    }


}

