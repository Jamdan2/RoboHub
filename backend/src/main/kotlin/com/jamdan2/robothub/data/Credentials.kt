package com.jamdan2.robothub.data

data class LoginCredentials(val username: String, val password: String)

data class SignUpCredentials(
        val firstName: String,
        val lastName: String,
        val username: String,
        val email: String,
        val password: String
)
