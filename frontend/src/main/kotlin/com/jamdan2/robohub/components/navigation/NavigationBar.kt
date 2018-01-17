package com.jamdan2.robohub.components.navigation

import react.*
import react.dom.*

class NavigationBar : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("NavigationBar") {

        }
    }
}

fun RBuilder.navigationBar() = child(NavigationBar::class) {}
