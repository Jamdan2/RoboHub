package com.jamdan2.kotlinWebapp

import kotlinext.js.*
import kotlin.browser.*
import react.dom.*
import react.router.dom.hashRouter

fun main(args: Array<String>) {
    require("styles.css")
    window.onload = {
        render(document.getElementById("root")!!) {
            hashRouter {
                application()
            }
        }
        println("Hello, world!")
    }
}
