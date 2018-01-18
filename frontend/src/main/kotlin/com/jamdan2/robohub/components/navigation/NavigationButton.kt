package com.jamdan2.robohub.components.navigation

import react.*
import react.dom.*
import react.router.dom.*

class NavigationButton : RComponent<NavigationButtonProps, RState>() {
    override fun RBuilder.render() {
        div("NavigationButton") {
            routeLink("fds") {
                button {
                    +props.text
                }
            }
        }
    }
}

interface NavigationButtonProps : RProps {
    var to: String
    var text: String
}

fun RBuilder.navigationButton(to: String, text: String) = child(NavigationButton::class) {
    attrs.to = to
    attrs.text = text
}
