package com.jamdan2.kotlinWebapp

import kotlin.browser.*
import kotlinext.js.*
import react.dom.*
import react.router.dom.*

fun main(args: Array<String>) {
    require("styles.css")
    window.onload = {
        render(document.getElementById("root")!!) {
            hashRouter {
                application()
            }
            p {
                +"Paragraph"
            }
            h1 {
                +"Header 1"
            }
            h2 {
                +"Header 2"
            }
            h3 {
                +"Header 3"
            }
            h4 {
                +"Header 4"
            }
            h5 {
                +"Header 5"
            }
            h6 {
                +"Header 6"
            }
        }
        println("Hello, world!")
    }
}
