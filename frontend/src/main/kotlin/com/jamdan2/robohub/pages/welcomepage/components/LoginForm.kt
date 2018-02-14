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

class LoginForm : RComponent<LoginFormProps, RState>() {
    private fun handleSubmit(e: Event) {
        e.preventDefault()
        val data = FormData(e.target as HTMLFormElement)
        XMLHttpRequest().apply {
            open("POST", "${window.location.href}/login")
            setRequestHeader("Content-Type", "application/json")
            onload = {
                println("Response: $response")
            }
            send(JSON.stringify(json(
                    "username" to data.get("username"),
                    "password" to data.get("password")
            )))
        }
    }

    override fun RBuilder.render() {
        div("LoginForm form") {
            button(classes = "close-button") {
                attrs.onClickFunction = props.onClose
                +"X"
            }
            div("form-container") {
                form {
                    attrs.onSubmitFunction = ::handleSubmit
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
