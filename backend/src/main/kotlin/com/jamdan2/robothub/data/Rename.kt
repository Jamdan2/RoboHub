package com.jamdan2.robothub.data

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import java.io.FileInputStream

private val serviceAccount = FileInputStream("service-account.json")

val options = FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://robohub-baa60.firebaseio.com")
        .build()!!

val app = FirebaseApp.initializeApp(options)!!

val db = FirestoreClient.getFirestore(app)
