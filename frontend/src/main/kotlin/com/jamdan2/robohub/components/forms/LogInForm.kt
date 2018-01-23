package com.jamdan2.robohub.components.forms

import kotlinx.html.*
import kotlinx.html.js.*
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import react.router.dom.*

class LogInForm : RComponent<LogInFormProps, RState>() {
    override fun RBuilder.render() {
        div("LogInForm form") {
            div("container") {
                form {
                    div("header") {
                        h2 {
                            +"Log In"
                        }
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
                        button(classes = "b-purple") {
                            +"Submit"
                        }
                        routeLink("/") {
                            +"Make an account"
                        }
                    }
                    div("footer") {
                        button(classes = "b-red") {
                            attrs.onClickFunction = props.onCancelButtonClick
                            +"Cancel"
                        }
                    }
                }
            }
        }
    }
}

interface LogInFormProps : RProps {
    var onCancelButtonClick: (Event) -> Unit
}

fun RBuilder.loginForm(onCancelButtonClick: (Event) -> Unit) = child(LogInForm::class) {
    attrs.onCancelButtonClick = onCancelButtonClick
}
