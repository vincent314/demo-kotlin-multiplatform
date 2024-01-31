package me.vince.fakedataserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FakeDataServerApplication

fun main(args: Array<String>) {
    runApplication<FakeDataServerApplication>(*args)
}
