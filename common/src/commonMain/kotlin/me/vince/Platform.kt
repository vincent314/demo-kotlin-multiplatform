package me.vince

expect val platform: String

class Greeting {
    fun greeting() = "Hello, $platform!"
}