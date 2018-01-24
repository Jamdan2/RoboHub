package com.jamdan2.robohub

import kotlinext.js.require
import kotlinext.js.requireAll
import react.dom.render
import react.router.dom.browserRouter
import kotlin.browser.document
import kotlin.browser.window

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
