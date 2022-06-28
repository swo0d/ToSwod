package com.example.toswod.domain.entity

import android.app.appsearch.RemoveByDocumentIdRequest
import java.util.*

data class RecipesData (
    val recipesId: UUID = UUID.randomUUID(),
    var recipesIngredients: String,
    var recipesVorbereitung: String){

    val recipesBild
        get() = "IMG_$recipesId.jpg"
}


