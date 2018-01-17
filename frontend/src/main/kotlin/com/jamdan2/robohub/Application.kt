package com.jamdan2.robohub

import react.*
import react.router.dom.*
import com.jamdan2.robohub.pages.*

class Application : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        switch {
            route("/", WelcomePage::class, true)
        }
    }
}

fun RBuilder.application() = child(Application::class) {}
