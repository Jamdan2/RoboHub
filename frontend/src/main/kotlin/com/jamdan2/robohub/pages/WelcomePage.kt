package com.jamdan2.robohub.pages

import com.jamdan2.robohub.components.forms.logInForm
import com.jamdan2.robohub.components.forms.modal
import com.jamdan2.robohub.components.forms.signUpForm
import com.jamdan2.robohub.components.navigation.navigationBar
import com.jamdan2.robohub.components.pageHeaders.welcomePageHeader
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.button

class WelcomePage : RComponent<RProps, WelcomePageState>() {
    override fun RBuilder.render() {
        modal(state.logInFormIsOpen) {
            logInForm {
                it.preventDefault()
                setState {
                    logInFormIsOpen = false
                }
            }
        }
        modal(state.signUpFormIsOpen) {
            signUpForm {
                it.preventDefault()
                setState {
                    signUpFormIsOpen = false
                }
            }
        }
        navigationBar {
            button {
                attrs.onClickFunction = {
                    it.preventDefault()
                    setState {
                        signUpFormIsOpen = true
                    }
                }
                +"Sign Up"
            }
            button {
                attrs.onClickFunction = {
                    it.preventDefault()
                    setState {
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
    var signUpFormIsOpen: Boolean
}
