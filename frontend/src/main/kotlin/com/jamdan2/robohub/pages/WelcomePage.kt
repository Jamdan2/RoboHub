package com.jamdan2.robohub.pages

import com.jamdan2.robohub.components.forms.loginForm
import react.*
import com.jamdan2.robohub.components.navigation.*
import com.jamdan2.robohub.components.pageHeaders.welcomePageHeader

class WelcomePage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        navigationBar {
            navigationButton("/", "Sign Up")
            navigationButton("/", "Log In")
        }
        welcomePageHeader("RoboHub", "Share your FRC robot with other teams")
        loginForm()
    }
}
