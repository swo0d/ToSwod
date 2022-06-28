package com.example.toswod.domain.entity

import java.util.*

data class TodoData(
    val todoId: UUID = UUID.randomUUID(),
    var todoTitle: String = "",
    var dateTodo:  Date = Date(),
    var isSolved: Boolean = false,
    var todoInfo: String = "") {

    val photoFileName
        get() = "IMG_$todoId.jpg"
}
