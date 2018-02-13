package com.jamdan2.robothub

import com.jamdan2.robothub.data.Credentials
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.GsonConverter
import io.ktor.html.respondHtml
import io.ktor.http.ContentType
import io.ktor.request.receive
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import kotlinx.html.*

@Suppress("unused")
fun Application.main() {
    install(CallLogging)
    install(DefaultHeaders)
    install(ContentNegotiation) {
        register(ContentType.Application.Json, GsonConverter())
    }
    routing {
        get("/") {
            call.respondHtml {
                head {
                    title("Kotlin Webapp")
                    script {
                        type = ScriptType.textJScript
                        src = "main.bundle.js"
                    }
                }
                body {
                    div {
                        id = "root"
                    }
                }
            }
        }
        post("/login") {
            val credentials = call.receive<Credentials>()
            println(credentials)
        }
    }
}
