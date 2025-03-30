package com.example.ite393exam

data class StudentData(
    val lastName: String,
    val firstName: String,
    val middleName: String,
    val studentId: String,
    val password: String,
    val gender: String,
    val birthdate: String,
    val university: String,
    val college: String,
    val course: String,
    val email: String = "None",
    val number: String = "None",
    val fatherName: String = "None",
    val motherName: String = "None",
    val guardianName: String = "None",
    val guardianNumber: String = "None",
    val currentAddress: String = "None",
    val permanentAddress: String = "None",
)
