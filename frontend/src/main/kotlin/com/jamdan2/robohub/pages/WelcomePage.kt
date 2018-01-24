package com.jamdan2.robohub.pages

import com.jamdan2.robohub.components.forms.loginForm
import com.jamdan2.robohub.components.forms.modal
import com.jamdan2.robohub.components.navigation.navigationBar
import com.jamdan2.robohub.components.pageHeaders.welcomePageHeader
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.button

class WelcomePage : RComponent<RProps, WelcomePageState>() {
    override fun RBuilder.render() {
        modal(state.logInFormIsOpen) {
            loginForm {
                it.preventDefault()
                setState {
                    logInFormIsOpen = false
                }
            }
        }
        navigationBar {
            button {
                attrs.onClickFunction = {
                    setState {
                        it.preventDefault()
                        logInFormIsOpen = true
                    }
                }
                +"Log In"
            }
        }
        welcomePageHeader("RoboHub", "Share your FRC robot with other teams")
    }
}

interface WelcomePageState : RState {
    var logInFormIsOpen: Boolean
}
