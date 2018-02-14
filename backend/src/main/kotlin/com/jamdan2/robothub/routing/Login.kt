package com.jamdan2.robothub.routing

import com.jamdan2.robothub.data.Credentials
import com.jamdan2.robothub.data.Database
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post

fun Route.login() {
    post("/login") {
        val credentials = call.receive<Credentials>()
        if (Database.login(credentials)) {
            call.respond(HttpStatusCode.Accepted, "Login successful")
        } else {
            call.respond(HttpStatusCode.BadRequest, "Incorrect username or password")
        }
    }
}
