package com.jamdan2.robohub.components.forms

import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import react.router.dom.routeLink

class SignUpForm : RComponent<SignUpFormProps, RState>() {
    override fun RBuilder.render() {
        div("SignUpForm form") {
            div("container") {
                form {
                    div("header") {
                        h1 {
                            +"Sign Up"
                        }
                    }
                    div("content") {
                        div("left") {
                            label {
                                +"First Name"
                            }
                            input(InputType.text) {}
                        }
                        div("right") {
                            label {
                                +"Last Name"
                            }
                            input(InputType.text) {}
                        }
                    }
                    div("content") {
                        label {
                            +"Email"
                        }
                        input(InputType.text) {}
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
                        label {
                            +"Verify Password"
                        }
                        input(InputType.password) {}
                    }
                    div("content") {
                        button(classes = "b-purple") {
                            +"Submit"
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

interface SignUpFormProps : RProps {
    var onCancelButtonClick: (Event) -> Unit
}

fun RBuilder.signUpForm(onCancelButtonClick: (Event) -> Unit) = child(SignUpForm::class) {
    attrs.onCancelButtonClick = onCancelButtonClick
}
