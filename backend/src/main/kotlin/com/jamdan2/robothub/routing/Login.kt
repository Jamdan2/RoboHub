package com.jamdan2.robothub.routing

import com.jamdan2.robothub.data.Credentials
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.routing.Route
import io.ktor.routing.post

fun Route.login() {
    post("/login") {
        val credentials = call.receive<Credentials>()
        println(credentials)
    }
}
