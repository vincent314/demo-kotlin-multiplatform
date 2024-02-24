package me.vince.fakedataserver

import java.time.LocalDateTime

data class Fact(val value: String, val dateTime: LocalDateTime = LocalDateTime.now())
