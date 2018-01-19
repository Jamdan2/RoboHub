package com.jamdan2.robohub.pages

import react.*
import com.jamdan2.robohub.components.*
import com.jamdan2.robohub.components.navigation.*

class WelcomePage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        navigationBar {
            navigationButton("/", "World")
            navigationButton("/", "Hello")
        }
        welcomePageHeader("RoboHub", "Share your FRC robot with other teams")
    }
}
