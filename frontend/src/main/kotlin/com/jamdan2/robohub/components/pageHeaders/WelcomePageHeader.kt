package com.jamdan2.robohub.components.pageHeaders

import react.*
import react.dom.div

class WelcomePageHeader : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("WelcomePageHeader") {
            div("wph-container") {
                children()
            }
        }
    }
}

fun RBuilder.welcomePageHeader(handler: RHandler<RProps>) = child(WelcomePageHeader::class, handler)
