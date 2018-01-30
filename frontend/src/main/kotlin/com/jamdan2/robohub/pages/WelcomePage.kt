package com.jamdan2.robohub.pages

import com.jamdan2.robohub.components.navigation.navigationBar
import com.jamdan2.robohub.components.pageHeaders.welcomePageHeader
import react.*
import react.dom.button
import react.dom.h1
import react.dom.h2

class WelcomePage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        navigationBar {
            button {
                +"Sign Up"
            }
            button {
                +"Log In"
            }
        }
        welcomePageHeader {
            h1("title") {
                +"RoboHub"
            }
            h2("subtitle") {
                +"Share your FRC robot with other teams."
            }
        }
    }
}
