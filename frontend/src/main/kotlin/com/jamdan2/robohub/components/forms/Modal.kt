package com.jamdan2.robohub.components.forms

import react.*
import react.dom.*

class Modal : RComponent<ModalProps, RState>() {
    override fun RBuilder.render() {
        div("Modal") {
            attrs.jsStyle.display = if (props.isOpen) "inline-block" else "none"
            div("animate") {
                children()
            }
        }
    }
}

interface ModalProps : RProps {
    var isOpen: Boolean
}

fun RBuilder.modal(isOpen: Boolean, handler: RHandler<ModalProps>) = child(Modal::class) {
    attrs.isOpen = isOpen
    handler()
}
