package com.example.toswod.domain.entity

import java.util.*

data class PasswordsData(
    val passwordId: UUID = UUID.randomUUID(),
    var passName: String,
    var email: String,
    var password: String,
    var company: String

)
