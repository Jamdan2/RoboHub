package com.jamdan2.robohub

import react.*
import react.router.dom.*

class Application : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        switch {

        }
    }
}

fun RBuilder.application() = child(Application::class) {}
