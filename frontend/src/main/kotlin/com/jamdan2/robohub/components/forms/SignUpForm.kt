package com.jamdan2.robohub.components.forms

import kotlinx.html.ButtonType
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

class SignUpForm : RComponent<SignUpFormProps, RState>() {
    override fun RBuilder.render() {
        div("SignUpForm form") {
            button(classes = "close-button") {
                attrs.onClickFunction = props.onClose
                +"X"
            }
            div("form-container") {
                form {
                    div("form-content") {
                        h1 { +"Sign Up" }
                    }
                    div("form-content") {
                        div("left") {
                            label { +"First Name" }
                            input(type = InputType.text) {}
                        }
                        div("right") {
                            label { +"Last Name" }
                            input(type = InputType.text) {}
                        }
                    }
                    div("form-content") {
                        label { +"Username" }
                        input(type = InputType.text) {}
                    }
                    div("form-content") {
                        label { +"Email" }
                        input(type = InputType.text) {}
                    }
                    div("form-content") {
                        label { +"Password" }
                        input(type = InputType.password) {}
                    }
                    div("form-content") {
                        label { +"Retype Password" }
                        input(type = InputType.password) {}
                    }
                    div("form-content") {
                        button(classes = "b-purple", type = ButtonType.submit) { +"Submit" }
                    }
                }
            }
        }
    }
}

interface SignUpFormProps : RProps {
    var onClose: (Event) -> Unit
}

fun RBuilder.signUpForm(onClose: (Event) -> Unit) = child(SignUpForm::class) {
    attrs.onClose = onClose
}
