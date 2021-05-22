package com.bersyte.simplerecipe.model


data class RecipeResponse(
    val href: String,
    val results: List<Result>,
    val title: String,
    val version: Double
)