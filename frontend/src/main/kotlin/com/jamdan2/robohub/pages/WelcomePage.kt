package com.jamdan2.robohub.pages

import com.jamdan2.robohub.components.navigation.navigationBar
import com.jamdan2.robohub.components.pageHeaders.welcomePageHeader
import react.*
import react.dom.button

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
        welcomePageHeader("RoboHub", "Share your FRC robot with other teams")
    }
}
