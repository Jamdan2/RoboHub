package com.jamdan2.robohub.utils.components

import kotlinext.js.js
import react.*
import react.dom.div
import react.dom.jsStyle

class Modal : RComponent<ModalProps, RState>() {
    override fun RBuilder.render() {
        div("Modal") {
            attrs.jsStyle = js {
                display = if (props.isOpen) "inline-block" else "none"
            }
            div("modal-container animate") {
                children()
            }
        }
    }
}

interface ModalProps : RProps {
    var isOpen: Boolean
}

fun RBuilder.modal(isOpen: Boolean, handler: RHandler<RProps>) = child(Modal::class) {
    attrs.isOpen = isOpen
    handler()
}
