package com.jamdan2.robohub.utils.components

import react.*
import react.dom.div

class NavigationBar : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("NavigationBar") {
            React.Children.map(props.children) { child ->
                div("navigationElement") {
                    child(child.asElementOrNull())
                }
            }
        }
    }
}

fun RBuilder.navigationBar(handler: RHandler<RProps>) = child(NavigationBar::class, handler)
