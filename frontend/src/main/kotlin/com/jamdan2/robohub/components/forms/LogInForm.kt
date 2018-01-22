package com.jamdan2.robohub.components.forms

import kotlinx.html.*
import kotlinx.html.js.*
import org.w3c.dom.events.Event
import react.*
import react.dom.*

class LogInForm : RComponent<LogInFormProps, RState>() {
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
                        button {
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
