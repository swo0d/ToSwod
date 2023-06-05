package com.example.toswod.domain.entity


import java.util.*


data class RecipesData (
    val recipeId: UUID = UUID.randomUUID(),
    var recipeIngredients: String = "",
    var recipeVorbereitung: String = "",
    var recipeTitle: String = "",
    var recipeDate: Date = Date(),
    var recipeIsSolved: Boolean = false,
    var recipeCategory: String = "",
    var recipePreparationTime: String = ""
) {
    val recipeImg
        get() = "IMG_$recipeId.jpg"
    }


