package com.jamdan2.robohub.pages.welcomepage

import com.jamdan2.robohub.pages.welcomepage.components.loginForm
import com.jamdan2.robohub.utils.components.modal
import com.jamdan2.robohub.pages.welcomepage.components.signUpForm
import com.jamdan2.robohub.utils.components.navigationBar
import com.jamdan2.robohub.pages.welcomepage.components.titleDisplay
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.button
import react.dom.h1
import react.dom.h2

@Suppress("UNUSED_PARAMETER")
class WelcomePage : RComponent<RProps, WelcomePageState>() {
    private fun openLoginForm(e: Event) {
        setState {
            loginFormIsOpen = true
        }
    }

    private fun closeLoginForm(e: Event) {
        setState {
            loginFormIsOpen = false
        }
    }

    private fun openSignUpForm(e: Event) {
        setState {
            signUpFormIsOpen = true
        }
    }

    private fun closeSignUpForm(e: Event) {
        setState {
            signUpFormIsOpen = false
        }
    }

    override fun RBuilder.render() {
        modal(state.loginFormIsOpen) {
            loginForm(::closeLoginForm)
        }
        modal(state.signUpFormIsOpen) {
            signUpForm(::closeSignUpForm)
        }
        navigationBar {
            button {
                attrs.onClickFunction = ::openSignUpForm
                +"Sign Up"
            }
            button {
                attrs.onClickFunction = ::openLoginForm
                +"Log In"
            }
        }
        titleDisplay {
            h1("title") {
                +"RobotHub"
            }
            h2("subtitle") {
                +"Share your FRC robot with other teams."
            }
        }
    }
}

interface WelcomePageState : RState {
    var loginFormIsOpen: Boolean
    var signUpFormIsOpen: Boolean
}
