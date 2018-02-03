package com.jamdan2.robohub

import com.google.firebase.FirebaseApp
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.html.*
import io.ktor.util.raw
import kotlinx.html.*

@Suppress("unused")
fun Application.main() {
    install(CallLogging)
    install(DefaultHeaders)
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
    }
}
