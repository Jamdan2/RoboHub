package com.jamdan2.robohub.components.forms

import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import react.router.dom.routeLink

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

fun RBuilder.logInForm(onCancelButtonClick: (Event) -> Unit) = child(LogInForm::class) {
    attrs.onCancelButtonClick = onCancelButtonClick
}
