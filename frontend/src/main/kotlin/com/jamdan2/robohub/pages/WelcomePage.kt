package com.jamdan2.robohub.pages

import com.jamdan2.robohub.components.forms.loginForm
import com.jamdan2.robohub.components.forms.modal
import com.jamdan2.robohub.components.forms.signUpForm
import com.jamdan2.robohub.components.navigation.navigationBar
import com.jamdan2.robohub.components.pageHeaders.welcomePageHeader
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

interface WelcomePageState : RState {
    var loginFormIsOpen: Boolean
    var signUpFormIsOpen: Boolean
}
