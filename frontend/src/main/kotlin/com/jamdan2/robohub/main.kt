package com.jamdan2.robohub

import kotlin.browser.*
import kotlinext.js.*
import react.dom.*
import react.router.dom.*

fun main(args: Array<String>) {
    requireAll(require.context("/", true, js("/\\.css$/")))
    window.onload = {
        render(document.getElementById("root")!!) {
           browserRouter {
                application()
           }
        }
        println("Hello, world!")
    }
}
