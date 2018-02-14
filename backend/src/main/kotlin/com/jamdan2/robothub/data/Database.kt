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

    fun login(credentials: Credentials): Boolean {
        val users = firestore.collection("users").get().get().documents
        users.forEach {
            if (it["username"] == credentials.username) {
                if (it["password"] == credentials.password) {
                    return true
                }
            }
        }
        return false
    }
}
