package com.jamdan2.robohub.pages

import react.*
import com.jamdan2.robohub.components.*
import com.jamdan2.robohub.components.navigation.*

class WelcomePage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        navigationBar {
            navigationButton("/", "Sign Up")
            navigationButton("/", "Log In")
        }
        welcomePageHeader("RoboHub", "Share your FRC robot with other teams")
    }
}
