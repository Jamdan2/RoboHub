package com.jamdan2.kotlinWebapp

import kotlinext.js.*
import kotlin.browser.*
import react.dom.*

fun main(args: Array<String>) {
    require("styles.css")
    window.onload = {
        render(document.getElementById("root")!!) {
            application()
        }
        println("Hello, world!")
    }
}
