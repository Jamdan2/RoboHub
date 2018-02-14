package com.jamdan2.robothub.data

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import java.io.FileInputStream

object Database {
    private val serviceAccount = FileInputStream("service-account.json")

    private val options = FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://robohub-baa60.firebaseio.com")
            .build()!!

    private val app = FirebaseApp.initializeApp(options)

    private val firestore = FirestoreClient.getFirestore(app)

    fun login(credentials: LoginCredentials): Boolean {
        val users = firestore.collection("users").get().get().documents
        users.forEach {
            if (it["username"] == credentials.username && it["password"] == credentials.password) {
                return true
            }
        }
        return false
    }

    @Throws(UsernameAlreadyExistsException::class, EmailAlreadyInUseException::class)
    fun signUp(credentials: SignUpCredentials) {
        val users = firestore.collection("users").get().get().documents
        users.forEach {
            if (it["username"] == credentials.username) {
                throw UsernameAlreadyExistsException("The username ${it["username"]} already exists.")
            }
            if (it["password"] == credentials.password) {
                throw EmailAlreadyInUseException("The email ${it["email"]} is already in use")
            }
        }
        firestore.collection("users").add(mapOf(
                "firstName" to credentials.firstName,
                "lastName" to credentials.lastName,
                "username" to credentials.username,
                "email" to credentials.email,
                "password" to credentials.password
        ))
    }
}

class UsernameAlreadyExistsException(message: String?) : Exception(message)

class EmailAlreadyInUseException(message: String?) : Exception(message)
