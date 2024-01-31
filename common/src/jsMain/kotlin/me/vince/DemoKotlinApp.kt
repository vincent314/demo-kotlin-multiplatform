package me.vince

import io.ktor.client.fetch.*
import kotlinx.browser.document
import kotlinx.html.dom.append
import kotlinx.html.js.h1
import org.w3c.fetch.Response

fun main() {
    val greetings = Greeting().greeting()
    println(greetings)
    document.getElementById("app")?.append {
        h1 { +greetings }
    }

    fetch("http://localhost:8888/api")
        .
        .then(Response::json)
        .then {
            val product = it as Product?
            println(product?.name)
        }
}
