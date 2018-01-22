package com.jamdan2.robohub.components.forms

import kotlinx.html.*
import react.*
import react.dom.*

class LogInForm : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("LogInForm form") {
            div("container") {
                form {
                    h2 {
                        +"Log In"
                    }
                    div("content") {
                        label {
                            +"Username"
                        }
                        input(InputType.text) {}
                    }
                    div("content") {
                        label {
                            +"Password"
                        }
                        input(InputType.password) {}
                    }
                    div("content") {
                        button {
                            +"Submit"
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.loginForm() = child(LogInForm::class) {}
