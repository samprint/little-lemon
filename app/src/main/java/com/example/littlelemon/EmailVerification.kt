package com.example.littlelemon

fun validateEmail(email: String): Boolean{
    val emailRegexPattern = "^(([^<>()\\[\\]\\\\.,;:\\s@\\\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\\\"]+)*)|(\\\".+\\\"))@((\\\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
    val emailRegex = Regex(emailRegexPattern)

    return email.matches(emailRegex)
}