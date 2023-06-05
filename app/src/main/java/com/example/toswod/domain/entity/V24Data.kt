package com.example.toswod.domain.entity

import java.util.*


data class V24Data(

    val v24Id: UUID = UUID.randomUUID(),
    var v24Title: String = "",
    var dateV24: Date = Date(),
    var isSolved: Boolean = false,
    var v24Info: String = ""
) {
    val photoV24FileName
        get() = "IMG_$v24Id.jpg"
}