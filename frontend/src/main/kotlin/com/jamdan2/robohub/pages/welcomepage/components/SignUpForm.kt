package com.jamdan2.robohub.pages.welcomepage.components

import kotlinx.html.ButtonType
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLFormElement
import org.w3c.dom.events.Event
import org.w3c.xhr.FormData
import org.w3c.xhr.XMLHttpRequest
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import kotlin.browser.window
import kotlin.js.json

class SignUpForm : RComponent<SignUpFormProps, RState>() {
    private fun handleSubmit(e: Event) {
        e.preventDefault()
        val data = FormData(e.target as HTMLFormElement)
        XMLHttpRequest().apply {
            open("POST", "${window.location.href}/sign-up")
            setRequestHeader("Content-Type", "application/json")
            onload = { println(response) }
            send(JSON.stringify(json(
                    "firstName" to data.get("firstName"),
                    "lastName" to data.get("lastName"),
                    "username" to data.get("username"),
                    "email" to data.get("email"),
                    "password" to data.get("password")
            )))
        }
    }

    override fun RBuilder.render() {
        div("SignUpForm form") {
            button(classes = "close-button") {
                attrs.onClickFunction = props.onClose
                +"X"
            }
            div("form-container") {
                form {
                    attrs.onSubmitFunction = ::handleSubmit
                    div("form-content") {
                        h1 { +"Sign Up" }
                    }
                    div("form-content") {
                        div("left") {
                            label { +"First Name" }
                            input(type = InputType.text, name = "firstName") {}
                        }
                        div("right") {
                            label { +"Last Name" }
                            input(type = InputType.text, name = "lastName") {}
                        }
                    }
                    div("form-content") {
                        label { +"Username" }
                        input(type = InputType.text, name = "username") {}
                    }
                    div("form-content") {
                        label { +"Email" }
                        input(type = InputType.text, name = "email") {}
                    }
                    div("form-content") {
                        label { +"Password" }
                        input(type = InputType.password, name = "password") {}
                    }
                    div("form-content") {
                        label { +"Retype Password" }
                        input(type = InputType.password, name = "retype-password") {}
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
