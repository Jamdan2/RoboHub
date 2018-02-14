package com.jamdan2.robothub.routing

import com.jamdan2.robothub.data.Database
import com.jamdan2.robothub.data.EmailAlreadyInUseException
import com.jamdan2.robothub.data.SignUpCredentials
import com.jamdan2.robothub.data.UsernameAlreadyExistsException
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post

fun Route.signUp() {
    post("/sign-up") {
        val credentials = call.receive<SignUpCredentials>()
        try {
            Database.signUp(credentials)
            call.respond(HttpStatusCode.Created, "Account successfully created")
        } catch (e: UsernameAlreadyExistsException) {
            call.respond(HttpStatusCode.Conflict, "Username already exists")
        } catch (e: EmailAlreadyInUseException) {
            call.respond(HttpStatusCode.Conflict, "Email is already in use")
        }
    }
}
