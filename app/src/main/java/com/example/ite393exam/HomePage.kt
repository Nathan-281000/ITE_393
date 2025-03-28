package com.example.ite393exam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.ite393exam.databinding.ActivityHomePageBinding


class HomePage : AppCompatActivity() {
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

    @SuppressLint("MissingInflatedId")
    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityHomePageBinding

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val passCourse = Intent(this, Course::class.java)
        val passModule = Intent(this, Modules::class.java)
        val passMap = Intent(this, Maps::class.java)
        val passProfile = Intent(this, Profile::class.java)
        val about = Intent(this, about::class.java)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)


        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth)
            val eventDetails = eventsMap[selectedDate] ?: "No events on this day"
            val intent = Intent(this, EventActivity::class.java).apply {
                putExtra("SELECTED_DATE", selectedDate)
                putExtra("EVENT_DETAILS", eventDetails)
            }
            startActivity(intent)
        }


        binding.course.setOnClickListener {
            startActivity(passCourse)
            finish()
        }
        binding.modules.setOnClickListener {
            startActivity(passModule)
            finish()
        }
        binding.maps.setOnClickListener {
            startActivity(passMap)
            finish()
        }
        binding.profile.setOnClickListener {
            startActivity(passProfile)
            finish()
        }
        binding.about.setOnClickListener {
            startActivity(about)
            finish()
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                goToFragment(LoggingOut())
            }
        })
    }

    private fun goToFragment(fragment: Fragment) {
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.close_pop, fragment).commit()
    }
}

