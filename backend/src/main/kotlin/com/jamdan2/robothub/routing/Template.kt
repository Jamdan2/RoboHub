package com.jamdan2.robothub.routing

import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.routing.Route
import io.ktor.routing.get
import kotlinx.html.*

fun Route.template() {
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
