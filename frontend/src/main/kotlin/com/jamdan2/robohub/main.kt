package com.jamdan2.robohub

import com.jamdan2.robohub.components.forms.loginForm
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
//                application()
               loginForm()
           }
        }
        println("Hello, world!")
    }
}
