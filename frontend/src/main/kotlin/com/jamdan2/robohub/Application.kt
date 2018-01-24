package com.jamdan2.robohub

import com.jamdan2.robohub.pages.WelcomePage
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.route
import react.router.dom.switch

class Application : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        switch {
            route("/", WelcomePage::class, true)
        }
    }
}

fun RBuilder.application() = child(Application::class) {}
