package me.vince

import kotlinx.browser.document
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.html.dom.append
import kotlinx.html.id
import kotlinx.html.js.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    val greetings = Greeting().greeting()
    println(greetings)

    val chuckNorrisFactService = ChuckNorrisFactService("http://localhost:8888/api")

    document.getElementById("app")?.append {
        h1 { +greetings }

        h1 { +helloModule() }

        ul { id = "factsElement" }

        button {
            +"Chuck Norris' Fact"
            onClickFunction = {
                GlobalScope.launch {
                    val fact = chuckNorrisFactService.fetchFact()
                    document.getElementById("factsElement")
                        ?.append {
                            li { +fact.value }
                        }
                }
            }
        }
    }
}
