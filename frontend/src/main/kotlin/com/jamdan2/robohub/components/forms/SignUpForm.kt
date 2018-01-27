package com.jamdan2.robohub.components.forms

import org.w3c.dom.events.Event
import react.*
import react.dom.*

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
                            input {}
                        }
                        div("right") {
                            label {
                                +"Last Name"
                            }
                            input {}
                        }
                    }
                    div("content") {
                        label {
                            +"Email"
                        }
                        input {}
                    }
                    div("content") {
                        label {
                            +"Username"
                        }
                        input {}
                    }
                    div("content") {
                        label {
                            +"Password"
                        }
                        input {}
                    }
                    div("content") {
                        label {
                            +"Verify Password"
                        }
                        input {}
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
