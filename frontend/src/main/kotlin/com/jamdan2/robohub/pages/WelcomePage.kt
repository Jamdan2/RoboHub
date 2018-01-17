package com.jamdan2.robohub.pages

import react.*
import react.dom.*

class WelcomePage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        h1 {
            +"I think I work?"
        }
    }
}
