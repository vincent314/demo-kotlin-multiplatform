package me.vince

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Fact(val value: String, val dateTime: LocalDateTime)


