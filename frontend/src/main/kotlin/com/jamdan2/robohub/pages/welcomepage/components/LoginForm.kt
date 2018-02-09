package com.jamdan2.robohub.pages.welcomepage.components

import kotlinx.html.ButtonType
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.*

class LoginForm : RComponent<LoginFormProps, RState>() {
    override fun RBuilder.render() {
        div("LoginForm form") {
            button(classes = "close-button") {
                attrs.onClickFunction = props.onClose
                +"X"
            }
            div("form-container") {
                form {
                    div("form-content") {
                        h1 { +"Login" }
                    }
                    div("form-content") {
                        label { +"Username" }
                        input(type = InputType.text, name = "username") {}
                    }
                    div("form-content") {
                        label { +"Password" }
                        input(type = InputType.password, name = "password") {}
                    }
                    div("form-content") {
                        button(classes = "b-purple", type = ButtonType.submit) { +"Submit" }
                    }
                }
            }
        }
    }
}

interface LoginFormProps : RProps {
    var onClose: (Event) -> Unit
}

fun RBuilder.loginForm(onClose: (Event) -> Unit) = child(LoginForm::class) {
    attrs.onClose = onClose
}
