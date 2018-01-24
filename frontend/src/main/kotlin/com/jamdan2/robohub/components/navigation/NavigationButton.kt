package com.jamdan2.robohub.components.navigation

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.div
import react.router.dom.routeLink

class NavigationButton : RComponent<NavigationButtonProps, RState>() {
    override fun RBuilder.render() {
        div("NavigationButton") {
            routeLink(props.to) {
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
