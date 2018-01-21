package com.jamdan2.robohub.components.forms

import kotlinx.html.*
import react.*
import react.dom.*

class LogInForm : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("LogInForm") {
            div("container") {
                h2 {
                    +"Log In"
                }
                label {
                    +"Username"
                }
                input(InputType.text) {}
                label {
                    +"Password"
                }
                input(InputType.password) {}
                button {
                    +"Submit"
                }
            }
        }
    }
}

fun RBuilder.loginForm() = child(LogInForm::class) {}
